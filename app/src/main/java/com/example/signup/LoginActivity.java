package com.example.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    EditText emailBox, passwordBox;
    Button loginBtn;
    TextView signupBtn;
    FirebaseAuth auth;
    ProgressDialog dialog;
    ImageView phone_otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        auth=FirebaseAuth.getInstance();
        emailBox=findViewById(R.id.emailBox);
        passwordBox=findViewById(R.id.passwordBox);
        phone_otp=findViewById(R.id.phone_otp);

        loginBtn=findViewById(R.id.loginBtn);
        signupBtn=findViewById(R.id.signupBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                String email,password;
                email=emailBox.getText().toString();
                password=passwordBox.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            dialog.dismiss();
                            if(task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this,main_page2.class));
                                Toast.makeText(LoginActivity.this, "Logged in successful", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this,"Please enter your credentials." , Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        phone_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, get_otp.class));
            }
        });
    }
}