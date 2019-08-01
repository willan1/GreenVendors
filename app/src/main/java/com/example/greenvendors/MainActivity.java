package com.example.greenvendors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText number=findViewById(R.id.number);

        Button register = findViewById(R.id.register);
        Button already =findViewById(R.id.pass);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code ="+254";
                String phonenumber = number.getText().toString().trim();
                if(phonenumber.isEmpty() || number.length()<10 || number.length() >10){
                    number.setError("Number is required");
                    number.requestFocus();
                    return;
                }
                String Pnumber= code + phonenumber;
                Intent intent= new Intent(MainActivity.this, Login.class);
                intent.putExtra("Pnumber", Pnumber);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent intent= new Intent(this, Items.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
