package com.example.vc.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vc.API.RetrofitClient;
import com.example.vc.Constants.Constnts;
import com.example.vc.R;
import com.example.vc.models.ProfileResponse;
import com.example.vc.models.User;
import com.example.vc.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextCurrentPassword, editTextNewPassword;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextName = view.findViewById(R.id.editTextName);
        editTextCurrentPassword = view.findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = view.findViewById(R.id.editTextNewPassword);

        view.findViewById(R.id.buttonSave).setOnClickListener(this);
        view.findViewById(R.id.buttonChangePassword).setOnClickListener(this);
        view.findViewById(R.id.buttonDelete).setOnClickListener(this);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void ChangePassword() {
        String currentpassword = editTextCurrentPassword.getText().toString().trim();
        String newpassword = editTextNewPassword.getText().toString().trim();

        if (currentpassword.isEmpty()) {
            editTextCurrentPassword.setError("Password required");
            editTextCurrentPassword.requestFocus();
            return;
        }

        if (newpassword.isEmpty()) {
            editTextNewPassword.setError("Enter new password");
            editTextNewPassword.requestFocus();
            return;
        }


        User user = SharedPrefManager.getInstance(getActivity()).getUser();
        String id = user.getId();
        String password = user.getPassword();
        String token = user.getToken();

        Call<ProfileResponse> call = RetrofitClient.getInstance()
                .getApi()
                .ChangePassword(id, password, Constnts.getInstance().auth.concat(token));
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });
    }

    private void ChangeName() {
        String name = editTextName.getText().toString().trim();


        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }


        User user = SharedPrefManager.getInstance(getActivity()).getUser();
        String id = user.getId();
        String myname = user.getName();
        String token = user.getToken();

        Call<ProfileResponse> call = RetrofitClient.getInstance()
                .getApi().changename(id, myname, Constnts.getInstance().auth.concat(token));

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {

                Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });
    }

//    private void deleteUser() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Are you sure?");
//        builder.setMessage("This action is irreversible...");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                User user = SharedPrefManager.getInstance(getActivity()).getUser();
//                String id = user.getId();
//                String token = user.getToken();
//
//                Call<ProfileResponse> call = RetrofitClient.getInstance().getApi()
//                        .delete(id,Constnts.getInstance().auth.concat(token));
//
//                call.enqueue(new Callback<ProfileResponse>() {
//                    @Override
//                    public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
//
//                        if (!response.body().isErr()) {
//                            SharedPrefManager.getInstance(getActivity()).clear();
//                            SharedPrefManager.getInstance(getActivity()).clear();
//                            Intent intent = new Intent(getActivity(), SignUpActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                            startActivity(intent);
//                        }
//
//                        Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<ProfileResponse> call, Throwable t) {
//
//                    }
//                });
//
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        AlertDialog ad = builder.create();
//        ad.show();
//    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonSave:
                ChangeName();
                break;
            case R.id.buttonChangePassword:
                ChangePassword();
                break;
//            case R.id.buttonDelete:
//                deleteUser();
//                break;
        }

    }

}
