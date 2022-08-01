package com.cookandroid.andtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtID, edtPW;
    Button btnLogin;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[유미미]다음 로그인창 구현");
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.txtReslut);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String str = edtID.getText().toString() + "님 로그인 되었습니다.";
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
//                String str1 = "입력 결과 : 아이디 " + edtID.getText().toString();
//                String str2 = "비밀번호 " + edtPW.getText().toString();
//                txtResult.setText(str1 + ", " + str2);

                txtName = findViewById(R.id.txtName);
                String name = txtName.getText().toString();

                btn = findViewById(R.id.btn);
                btn.setText(name);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = txtName.getText().toString();
                        Toast.makeText(getApplicationContext(), "이름 : " + name, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}