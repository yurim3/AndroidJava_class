package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtx, edty;
    TextView txtResult;
//    Button btnNum0, btnNum1,  btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9
    Button btnAdd, btnSub, btnMul;
    Button[] btnNums = new Button[10]; //버튼 객체 배열 10개
    Integer[] ids = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6,
            R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < btnNums.length; i++) { //0~9 버튼 findviewBy...
            btnNums[i] = findViewById(ids[i]);

            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtx.isFocused()){
                        String s = edtx.getText().toString() + index;
                        edtx.setText(s);
                    }else if(edty.isFocused()) {
                        String s = edty.getText().toString() + index;
                        edty.setText(s);
                    }else {
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        edtx = findViewById(R.id.edtx);
        edty = findViewById(R.id.edty);
        txtResult = findViewById(R.id.txtResult);
//        btnNum0 = findViewById(R.id.btnNum0);
//        btnNum1 = findViewById(R.id.btnNum1);
//        btnNum2 = findViewById(R.id.btnNum2);
//        btnNum3 = findViewById(R.id.btnNum3);
//        btnNum4 = findViewById(R.id.btnNum4);
//        btnNum5 = findViewById(R.id.btnNum5);
//        btnNum6 = findViewById(R.id.btnNum6);
//        btnNum7 = findViewById(R.id.btnNum7);
//        btnNum8 = findViewById(R.id.btnNum8);
//        btnNum9 = findViewById(R.id.btnNum9);
          btnAdd = findViewById(R.id.btnAdd);
          btnSub = findViewById(R.id.btnSub);
          btnMul = findViewById(R.id.btnMul);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = edtx.getText().toString();
                String y = edty.getText().toString();
                int result = Integer.parseInt(x) + Integer.parseInt(y);
                txtResult.setText("계산 결과 : " + result);

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = edtx.getText().toString();
                String y = edty.getText().toString();
                int result = Integer.parseInt(x) - Integer.parseInt(y);
                txtResult.setText("계산 결과 : " + result);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = edtx.getText().toString();
                String y = edty.getText().toString();
                int result = Integer.parseInt(x) * Integer.parseInt(y);
                txtResult.setText("계산 결과 : " + result);
            }
        });

        setTitle("유미미");

    } //onCreat()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); //xml을 메뉴로 생성
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x = Integer.parseInt(edtx.getText().toString());
        int y = Integer.parseInt(edty.getText().toString());
        switch (item.getItemId()){
            case R.id.itemAdd :
                txtResult.setText("계산 결과 : " + (x + y));
                break;
            case R.id.itemSub :
                txtResult.setText("계산 결과 : " + (x - y));
                break;
            case R.id.itemMul :
                txtResult.setText("계산 결과 : " + (x * y));
                break;
            case R.id.itemExit :
                finish();
        }
        return true;
    }
}