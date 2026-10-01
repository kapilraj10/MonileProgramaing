package com.example.mynewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText num1, num2;
Button add_btn, sub_btn;
TextView txt_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       num1 = (EditText)findViewById(R.id.num1);
       num2 = (EditText)findViewById(R.id.num2);

        add_btn = (Button)findViewById(R.id.addButton);
        sub_btn = (Button)findViewById(R.id.subtractButton);


        txt_answer = (TextView)findViewById(R.id.answer);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double sum = n1+n2;
                txt_answer.setText("The sum of two number is : " + Double.toString(sum));

            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double minus = n1-n2;
                txt_answer.setText("The difference of two number is : " + Double.toString(minus));

            }
        });


    }
}