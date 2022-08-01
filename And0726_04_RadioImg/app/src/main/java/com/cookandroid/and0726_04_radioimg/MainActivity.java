package com.cookandroid.and0726_04_radioimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int imgType = 1; //1 == cat, 2 == dog
    Button btnWordShow;
    Button btnWebsite;
    RadioGroup rg;
    ImageView img;
    RadioButton rbcat;
    RadioButton rbdog;
    EditText edtWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWordShow = findViewById(R.id.btnWordShow);
        btnWebsite = findViewById(R.id.btnWebsite);
        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);
        rbcat = findViewById(R.id.rbcat);
        rbdog = findViewById(R.id.rbdog);
        edtWebsite = findViewById(R.id.edtWebsite);

        btnWordShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edtWebsite.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(edtWebsite.getText().toString()));
                startActivity(urlOpen);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbcat:
                        img.setImageResource(R.drawable.cat);
                        break;

                    case R.id.rbdog:
                        img.setImageResource(R.drawable.dog);
                        break;
                }
            }
        });
    }
}