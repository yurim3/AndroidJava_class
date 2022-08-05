package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    CheckBox chGame, chMugic, chExer;
    Button btnEnd;
    ArrayList<String> hobby = new ArrayList<String>(); //동적 객체 배열>> 제네릭 구조      String[] arrHobby;랑 똑같음
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        chGame = findViewById(R.id.chGame);
        chMugic = findViewById(R.id.chMugic);
        chExer = findViewById(R.id.chExer);
        btnEnd = findViewById(R.id.btnEnd);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                try {
                    age = Integer.parseInt(edtAge.getText().toString());
                }catch (Exception e){};

                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("name", name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);

            }
        });

        chGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hobby.add(chGame.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chGame.getText().toString()));
                }
            }
        });

        chMugic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hobby.add(chMugic.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chMugic.getText().toString()));
                }
            }
        });

        chExer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hobby.add(chExer.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chExer.getText().toString()));
                }
            }
        });
    }
}