package com.cookandroid.and0801_activitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbSecond, rbThird;
    Button btnOpen;
    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        rbSecond = findViewById(R.id.rbSecond);
        rbThird = findViewById(R.id.rbThird);
        btnOpen = findViewById(R.id.btnOpen);
        edtContent = findViewById(R.id.edtContent);
        setTitle("첫 번째 화면");

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString(); //넘겨줄 내용 가져오기
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rbSecond:
                        Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                        in.putExtra("Content", str);
                        startActivity(in);
                    break;

                    case R.id.rbThird:
                        Intent in2 = new Intent(getApplicationContext(), ThirdActivity.class);
                        in2.putExtra("Content", str);
                        startActivity(in2);
                        break;
                }

                //////////////////////////////////선생님 코드///////////////////////////////////////
//                if(rg.getCheckedRadioButtonId() == R.id.rbSecond){
//                    Intent in = new Intent(getApplicationContext(), SecondActivity.class);
//                    startActivity(in);
//                }else {
//                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
//                    startActivity(in);
//                }

            }
        });
    }
}