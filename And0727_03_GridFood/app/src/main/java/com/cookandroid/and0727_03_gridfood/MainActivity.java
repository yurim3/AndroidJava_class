package com.cookandroid.and0727_03_gridfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rbMenu1, rbMenu2, rbMenu3;
    RadioGroup rg;
    Button btnEnd;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbMenu1 = findViewById(R.id.rbMenu1);
        rbMenu2 = findViewById(R.id.rbMenu2);
        rbMenu3 = findViewById(R.id.rbMenu3);
        rg = findViewById(R.id.rg);
        btnEnd = findViewById(R.id.btnEnd);
        img = findViewById(R.id.img);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rbMenu1: Toast.makeText(getApplicationContext(), "해물 파스타 선택", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbMenu2: Toast.makeText(getApplicationContext(), "토마토 파스타 선택", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbMenu3: Toast.makeText(getApplicationContext(), "까르보나라 선택", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbMenu1:img.setImageResource(R.drawable.hea); break;

                    case R.id.rbMenu2:img.setImageResource(R.drawable.tomato); break;

                    case R.id.rbMenu3:img.setImageResource(R.drawable.gga); break;
                }
            }
        });
    }
}