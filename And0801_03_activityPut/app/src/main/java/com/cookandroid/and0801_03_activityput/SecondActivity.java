package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    TextView txtShowName, txtShowAge, txtShowHob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("두 번째 화면");
        txtShowName = findViewById(R.id.txtShowName);
        txtShowAge = findViewById(R.id.txtShowAge);
        txtShowHob = findViewById(R.id.txtShowHob);

        Intent in = getIntent();
        String name = in.getStringExtra("name");
        txtShowName.setText("이름: " + name);

        int age = in.getIntExtra("age", 0);
        txtShowAge.setText("나이: " + age);

        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");
        txtShowHob.setText("취미: " + hobby);
    }
}