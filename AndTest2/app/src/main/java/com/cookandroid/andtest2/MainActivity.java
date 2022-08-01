package com.cookandroid.andtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtn2, rbtn3;
    RadioGroup rbtngr;
    Button btnok, btncancel, qjxms;
    CheckBox ghkftjdghk;
    String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유미미");
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        rbtngr = findViewById(R.id.rbtngr);
        btnok = findViewById(R.id.btnok);
        btncancel = findViewById(R.id.btncancel);
        qjxms = findViewById(R.id.qjxms);
        ghkftjdghk = findViewById(R.id.ghkftjdghk);

        ghkftjdghk.setChecked(true);
        ghkftjdghk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)qjxms.setEnabled(true);
                else qjxms.setEnabled(false);
            }
        });
        rbtngr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String out = grade + "학년입니다.";
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

        rbtngr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == 0) grade = "2학년";
                else grade = "3학년";
                ///////////////////////////////////////////////////
                //if(radioGroup.getCheckedRadioButtonId()==R.id.rbtn2)
                //    grade = rbtn2.getText().toString();
                //else grade = rbtn3.getText().toString();
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "선택한 학년 : " + grade, Toast.LENGTH_SHORT).show();
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtngr.clearCheck();
                String str1 = "취소하였습니다.";
                Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_SHORT).show();
            }
        });




    }
}