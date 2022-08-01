package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[4];
    Integer[] chkText = {R.id.chkStr, R.id.chkGra, R.id.chkKi, R.id.chkJa};
    TextView txtResult;
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        btnEnd = findViewById(R.id.btnEnd);


        for(int i = 0; i < chkList.length; i++){
            chkList[i] = findViewById(chkText[i]);
        }

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                for(int i = 0; i < chkList.length; i++){
                    if(chkList[i].isChecked() == true){
                        str += chkList[i].getText().toString() + ". ";
                    }
                }
                if(txtResult.equals(""))txtResult.setText("선택되지 않았습니다.");
                else txtResult.setText("선택 결과: " + str);
            }
        });
///////////////////////////setOnCheckedChangeListener 추가//////////////////////////////////////////
        for(int i = 0; i < chkList.length; i++){
            final int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btnEnd.performClick(); //btnEnd의 Onclick 함수 호출하는 것과 같음
                }
            });
        }
    }


}