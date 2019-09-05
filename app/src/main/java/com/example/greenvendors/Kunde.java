package com.example.greenvendors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kunde extends AppCompatActivity {

   int price=0;
   int amount;
   Button button1;
   Button button2;
   TextView textView1;
   TextView textView2;
   Button button3;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunde);



        button1=findViewById(R.id.plus);
        button2=findViewById(R.id.minus);
        textView1=findViewById(R.id.text);
        textView2=findViewById(R.id.amount);
        button3=findViewById(R.id.cart);

        textView1.setText("0");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price = price + 1;
                amount=price*30;
                textView1.setText(String.valueOf(price));
                textView2.setText(String.valueOf(amount));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (price >= 1) { price --; }{
                    amount=price*30;
                    textView1.setText(String.valueOf(price));
                textView2.setText(String.valueOf(amount));}
            }

        });






    }




}
