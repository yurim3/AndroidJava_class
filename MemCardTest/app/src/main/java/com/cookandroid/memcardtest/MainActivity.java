package com.cookandroid.memcardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edPizza, edSal, edSpa;
    CheckBox chkMemCard;
    Button btnCal, btnReset;
    TextView txtNum, txtTotal;
    int num = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[ONE!DREAM!안녕하세요,투모로우바이투게더입니다!]멤버쉽 카드 할인");
        edPizza = findViewById(R.id.edPizza);
        edSal = findViewById(R.id.edSla);
        edSpa = findViewById(R.id.edSpa);
        chkMemCard = findViewById(R.id.chkMemCard);
        btnCal = findViewById(R.id.btnCal);
        btnReset = findViewById(R.id.btnReset);
        txtNum = findViewById(R.id.txtNum);
        txtTotal = findViewById(R.id.txtTotal);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edPizza.setText("0");
                edSal.setText("0");
                edSpa.setText("0");
                txtNum.setText("주문 개수 : 0");
                txtTotal.setText("주문 금액 : 0");
                chkMemCard.setChecked(false);
            }
        });
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nP = Integer.parseInt(edPizza.getText().toString());
                int nSp = Integer.parseInt(edSpa.getText().toString());
                int nSa = Integer.parseInt(edSal.getText().toString());
                num = nP + nSa + nSp; //토탈 개수
                if(chkMemCard.isChecked()){
                    total = (int)((nP*25000 + nSp*15000 + nSa*10000)*0.8);
                }
                else total = nP * 25000 + nSp * 15000 + nSa * 10000;
                txtNum.setText("주문 개수 : " + num);
                txtTotal.setText("주문 금액 : " + total);
            }
        });

    }
}