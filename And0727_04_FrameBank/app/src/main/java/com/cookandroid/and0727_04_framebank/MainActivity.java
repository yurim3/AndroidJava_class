package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout lay1, lay2, lay3;
    EditText edtInMon, edtOutMon;
    Button btn1, btn2, btn3, btnInMon, btnOutMon;
    TextView txtMon;
    int total = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("어마무시한 유미미의 은행");
        lay1 = findViewById(R.id.lay1);
        lay2 = findViewById(R.id.lay2);
        lay3 = findViewById(R.id.lay3);
        edtInMon = findViewById(R.id.edtInMon);
        edtOutMon = findViewById(R.id.edtOutMon);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnInMon = findViewById(R.id.btnInMon);
        btnOutMon = findViewById(R.id.btnOutMon);
        txtMon= findViewById(R.id.txtMon);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#FFF9C4"));
                btn2.setBackgroundColor(Color.parseColor("#d3d3d3"));
                btn3.setBackgroundColor(Color.parseColor("#d3d3d3"));
                lay1.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.INVISIBLE);
                lay3.setVisibility(View.INVISIBLE);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundColor(Color.parseColor("#FFF9C4"));
                btn1.setBackgroundColor(Color.parseColor("#d3d3d3"));
                btn3.setBackgroundColor(Color.parseColor("#d3d3d3"));
                lay2.setVisibility(View.VISIBLE);
                lay1.setVisibility(View.INVISIBLE);
                lay3.setVisibility(View.INVISIBLE);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setBackgroundColor(Color.parseColor("#FFF9C4"));
                btn1.setBackgroundColor(Color.parseColor("#d3d3d3"));
                btn2.setBackgroundColor(Color.parseColor("#d3d3d3"));
                lay3.setVisibility(View.VISIBLE);
                lay1.setVisibility(View.INVISIBLE);
                lay2.setVisibility(View.INVISIBLE);

            }
        });
        btnOutMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInMon.getText().toString());
                total += n; txtMon.setText("잔액: "+total+"원");
                Toast.makeText(getApplicationContext(),
                        n+"원 입금\n잔액은 "+total+"입니다.", Toast.LENGTH_SHORT).show();
                edtInMon.setText("0");
            }
        });

        btnOutMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutMon.getText().toString());
                total -= n; txtMon.setText("잔액: "+total+"원");
                Toast.makeText(getApplicationContext(),
                        n+"원 출금\n잔액은 "+total+"입니다.", Toast.LENGTH_SHORT).show();
                edtOutMon.setText("0");
            }
        });



    }
}