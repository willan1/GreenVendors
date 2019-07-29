package com.example.greenvendors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {
    private String verificationid;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;
    private EditText verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String Pnumber=getIntent().getStringExtra("Pnumber");
        mAuth=FirebaseAuth.getInstance();
        progressbar=findViewById(R.id.progressbar);
        verify=findViewById(R.id.verify);

        sendVerificationCode(Pnumber);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code=verify.getText().toString().trim();
                if(code.isEmpty() || code.length()<6){
                    verify.setError("Enter code ...");
                    verify.requestFocus();
                    return;
                }

                verifycode(code);

            }
        });

    }
    private void verifycode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid, code);
        signInWithCredential (credential);

    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(Login.this, Items.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }



        });
    }

    private void sendVerificationCode(String Pnumber){
        progressbar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(Pnumber, 60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, mCallBack);


    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationid=s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
            if(code != null){

                verifycode(code);
            }


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() !=null){
            Intent intent=new Intent(this, Items.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
