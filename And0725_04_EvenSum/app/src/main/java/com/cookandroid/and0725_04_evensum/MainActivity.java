package com.cookandroid.and0725_04_evensum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_num1;
    EditText edt_num2;
    Button btn_sum;
    Button btn_pointer;
    TextView txt_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btn_sum = findViewById(R.id.btn_sum);
        btn_pointer = findViewById(R.id.btn_pointer);
        txt_Result = findViewById(R.id.txt_Result);


        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt_num1.getText().toString());
                int n2 = Integer.parseInt(edt_num2.getText().toString());
                int sum = 0;
                for(int i = n1; i < n2; i++){
                    if(i % 2 == 0){
                        sum += i;
                    }
                }
                txt_Result.setText("계산 결과: " +n1 + "와 " + n2 + "까지의 짝수의 합 = " + sum);
            }
        });

        btn_pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt_num1.getText().toString());
                int n2 = Integer.parseInt(edt_num2.getText().toString());
                int result = n2 - (n2%n1);

                txt_Result.setText("사용할 수 있는 포인트는: " + result);
            }
        });

///////////////////////////////쌤이 풀어 준 코드////////////////////////////////////////////////////

//        btn_sum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x = Integer.parseInt(edt_num1.getText().toString()); //포인트 기준
//                int y = Integer.parseInt(edt_num2.getText().toString()); //내 포인트
//                int result = 0;
//                for(int i = x; i <= y; i++) {
//                    if(i % 2 == 0){
//                        result += i;
//                    }
//                }
//                txt_Result.setText(x + "~" + y + "까지 짝수의 합 결과: " + result);
//            }
//        });
//        btn_pointer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x = Integer.parseInt(edt_num1.getText().toString()); //포인트 기준
//                int y = Integer.parseInt(edt_num2.getText().toString()); //내 포인트
//                int result = y-y%x;
//                if(y < x) txt_Result.setText("가용할 포인트가 부족합니다.");
//                else txt_Result.setText("가용 포인트는 " + result + "원입니다.");
//            }
//        });
    }
}