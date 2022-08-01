package com.cookandroid.and0726_03_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rbEnhypen;
    RadioButton rbTxt;
    RadioButton rbDay6;
    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rbEnhypen: Toast.makeText(getApplicationContext(), "엔하이픈 투표", Toast.LENGTH_SHORT).show();
                    break;

                    case R.id.rbTxt: Toast.makeText(getApplicationContext(), "투바투 투표", Toast.LENGTH_SHORT).show();
                    break;

                    case R.id.rbDay6: Toast.makeText(getApplicationContext(), "데이식스 투표", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
    }
}