package com.example.vc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vc.models.DefaultResponse;
import com.example.vc.R;
import com.example.vc.API.RetrofitClient;
import com.example.vc.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail, editTextPassword, editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextEmail = findViewById(R.id.regMail);
        editTextName = findViewById(R.id.regName);
        editTextPassword = findViewById(R.id.regPassword);
        findViewById(R.id.regBtn).setOnClickListener(this);
        findViewById(R.id.already_have_account).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    private void userSignUp() {

        String email = editTextEmail.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {

            editTextPassword.setError("Password should be 8 character long");
            editTextPassword.requestFocus();
            return;

        }

        Call<DefaultResponse> call = RetrofitClient.getInstance()
                .getApi()
                .signup(email, password, name);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 200) {
                    DefaultResponse dr = response.body();
                    Toast.makeText(SignUpActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                } else if (response.code() == 509) {

                    Toast.makeText(SignUpActivity.this,"User already exist",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regBtn:
                userSignUp();
                break;
            case R.id.already_have_account:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}
