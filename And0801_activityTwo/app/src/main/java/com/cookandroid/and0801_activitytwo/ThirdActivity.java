package com.cookandroid.and0801_activitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnThiEnd;
    TextView txtContent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnThiEnd = findViewById(R.id.btnThiEnd);
        txtContent3 = findViewById(R.id.txtContent3);
        setTitle("세 번째 화면");
        /////////////////////////////////////////////////////////////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("Content"); //변수이름이 똑같아야 함!
        ////////////////////////////////////////////////////////////////////////
        txtContent3.setText("넘겨받은 내용: " + str);

        btnThiEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는 거 (종료)
            }
        });
    }
}