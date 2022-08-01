package com.cookandroid.and0725_05_imgchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnChange;
    Button btnHide;
    ImageView img;
    int imgType = 1; // 1 == dog, 2 == cat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChange = findViewById(R.id.btnChange);
        btnHide = findViewById(R.id.btnHide);
        img = findViewById(R.id.img);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType == 1){
                    img.setImageResource(R.drawable.dog);
                    imgType = 2;
                }else{
                    img.setImageResource(R.drawable.cat);
                    imgType = 1;
                }
            }
        });
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility() == View.VISIBLE){
                    img.setVisibility(View.INVISIBLE);
                    btnHide.setText("숨기기");
                }else{
                    img.setVisibility(View.VISIBLE);
                    btnHide.setText("보이기");
                }
            }
        });
    }
}