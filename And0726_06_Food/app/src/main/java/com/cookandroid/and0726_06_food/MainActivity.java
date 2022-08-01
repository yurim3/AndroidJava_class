package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkStart;
    RadioGroup rg;
    RadioButton rbKor;
    RadioButton rbChi;
    RadioButton rbBun;
    RadioButton rbNight;
    Button btnReset;
    TextView txt2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkStart = findViewById(R.id.chkStart);
        rg = findViewById(R.id.rg);
        rbKor = findViewById(R.id.rbKor);
        rbChi = findViewById(R.id.rbChi);
        rbBun = findViewById(R.id.rbBun);
        rbNight = findViewById(R.id.rbNight);
        btnReset = findViewById(R.id.btnReset);
        txt2 = findViewById(R.id.txt2);
        img = findViewById(R.id.img);

        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkStart.isChecked() == true) {
                    txt2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    txt2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbKor: img.setImageResource(R.drawable.cat); break;

                    case R.id.rbChi: img.setImageResource(R.drawable.dog); break;

                    case R.id.rbBun: img.setImageResource(R.drawable.fox); break;

                    case R.id.rbNight: img.setImageResource(R.drawable.horse); break;
                }
            }
        });
    }
}