package com.cookandroid.and0729_03_sdmem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnMkdir, btnDeldir, btnFileList;
    EditText edtSD;
    String strSDPath; File myDir; //앱 디렉터리 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE); //쓰기 모드로 사용할 수 있게 해 주는 거?

        btnRead = findViewById(R.id.btnRead);
        btnMkdir = findViewById(R.id.btnMkdir);
        btnDeldir = findViewById(R.id.btnDeldir);
        btnFileList = findViewById(R.id.btnFileList);
        edtSD = findViewById(R.id.edtSD);

        //핸드폰의 SD카드 절대 경로
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        myDir = new File(strSDPath + "/myDir"); //앱 이름의 폴더 생성

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myDir.exists())myDir.mkdir(); //같은 폴더에서 같은 제목의 파일 없도록?
            }
        });

        btnDeldir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = new FileInputStream(strSDPath+"/myDir/test.txt");
                    byte[] in = new byte[inFs.available()];
                    inFs.read(in);
                    edtSD.setText(new String(in));
                    inFs.close();
                }catch (Exception e){
                }
            }
        });

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File[] sysFiles = (new File(strSDPath).listFiles());
                String strFname = "파일 및 폴더 개수: " + sysFiles.length;
                for(int i = 0; i <sysFiles.length; i++){
                    if (sysFiles[i].isDirectory())
                        strFname += "\n[폴더]" + sysFiles[i].toString();
                    if(sysFiles[i].isFile())
                        strFname += "\n[파일]" + sysFiles[i].toString();
                }
                edtSD.setText(strFname);
            }
        });
    }
}