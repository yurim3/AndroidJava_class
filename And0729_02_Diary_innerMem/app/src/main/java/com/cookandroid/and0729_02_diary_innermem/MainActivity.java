package com.cookandroid.and0729_02_diary_innermem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker1;
    EditText edtDiary;
    Button btnWrite;
    String fileName; //파일 이름
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        setTitle("[쉿!유림이의일기장!아무도보면안됨!]내장메모리에 저장");
        datePicker1 = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져오기
        int month = cal.get(Calendar.MONTH); //시스템 달력에서 월(0부터 시작) 가져오기
        int day = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기
        fileName = year + "_" + (month+1) + "_" + day + ".txt"; //파일이름 만들기 "년_월_일.txt"

        //오늘 날짜의 일기가 있으면 읽어서 edtDiary에 setText() 하기
        String str = readDiary(fileName); //일기 읽기 완성
        edtDiary.setText(str);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE); //MODE_PRIVATE: 파일 쓰기용으로 open
                    String str = edtDiary.getText().toString() + "\n";
                    outFs.write(str.getBytes());
                    outFs.close(); //파일 다 썼으면 반드시 닫아 주기!!!
                    Toast.makeText(getApplicationContext(), fileName + "파일 저장해쪄염 ㅎㅅㅎ",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                }
            }
        });
        datePicker1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m+1) + "_" + d + ".txt";
                String str = readDiary(fileName); //일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });
    }

    //파일 읽기 함수 따로 정의
    String readDiary(String fname){
        String diaryData = null; //일기 내용 저장하는 변수
        try {
            FileInputStream inFs = openFileInput(fname);
            byte[] in = new byte[500];
            inFs.read(in); //str.toString();
            diaryData = (new String(in)).trim();    // 양끝에 공백제거함수 trim()
            btnWrite.setText("수정하기");
            inFs.close();
        }catch (Exception e){
            btnWrite.setText("새로저장");
        }
        return diaryData;
    }
}