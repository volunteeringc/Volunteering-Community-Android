package com.example.vc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.vc.API.RetrofitClient;
import com.example.vc.R;
import com.example.vc.models.LoginResponse;
import com.example.vc.models.User;
import com.example.vc.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private ProgressBar loginProgress;
    private Button loginBtn;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.loginBtn).setOnClickListener(this);
        findViewById(R.id.creatAccount).setOnClickListener(this);
        editTextEmail = findViewById(R.id.login_email);
        editTextPassword = findViewById(R.id.login_password);
//        loginProgress = findViewById(R.id.login_progressBar);
//
//        loginProgress.setVisibility(View.INVISIBLE);
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loginProgress.setVisibility(View.VISIBLE);
//                loginBtn.setVisibility(View.INVISIBLE);
//
//                final String mail = editTextEmail.getText().toString();
//                final String password = editTextPassword.getText().toString();
//
//                if (mail.isEmpty() || password.isEmpty()) {
//                    editTextEmail.setError("Please Complete all fields");
//                    editTextPassword.setError("Please Complete all fields");
//                    loginBtn.setVisibility(View.VISIBLE);
//                    loginProgress.setVisibility(View.INVISIBLE);
//                } else {
//                    userLogin();
//                }
//
//
//            }
//        });
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

    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


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

            editTextPassword.setError("Password should be 6 character long");
            editTextPassword.requestFocus();
            return;

        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .login(email, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                if (response.code() == 200) {
                    SharedPrefManager.getInstance(LoginActivity.this)
                            .saveUser(new User(loginResponse.getID(), loginResponse.getToken()));
                    SharedPrefManager.getInstance(LoginActivity.this).setLogingStatus(true);
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else if (response.code() == 500) {

                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginBtn:

                userLogin();
                break;
            case R.id.creatAccount:
                startActivity(new Intent(this, SignUpActivity.class));

                break;
        }
    }
}