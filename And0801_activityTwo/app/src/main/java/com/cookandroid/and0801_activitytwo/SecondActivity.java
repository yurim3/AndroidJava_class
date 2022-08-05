package com.cookandroid.and0801_activitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button btnSecEnd;
    TextView txtContent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnSecEnd = findViewById(R.id.btnSecEnd);
        txtContent2 = findViewById(R.id.txtContent2);
        setTitle("두 번째 화면");
        /////////////////////////////////////////////////////////////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("Content"); //변수이름이 똑같아야 함!
        ////////////////////////////////////////////////////////////////////////
        txtContent2.setText("넘겨받은 내용: " + str);

        btnSecEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는 거 (종료)
            }
        });
    }
}