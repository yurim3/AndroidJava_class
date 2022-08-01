package com.cookandroid.and0728_02_menudlgtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtPhNum, edtGen;
    Button btnGen, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴실습[신유미미]");

        edtPhNum = findViewById(R.id.edtPhNum);
        edtGen = findViewById(R.id.edtGen);
        btnGen = findViewById(R.id.btnGen);
        btnSignup = findViewById(R.id.btnSignup);

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.popup_man:
                                edtGen.setText("남자");
                                return true;

                            case R.id.popup_woman:
                                edtGen.setText("여자");
                                return true;

                            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                    }
                });
                p.show();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("가입 정보 확인");
                        dlg.setIcon(R.mipmap.ic_launcher_round);
                        dlg.setMessage("전화번호: " + edtPhNum.getText() + "\n성별: " + edtGen.getText());
                        dlg.setPositiveButton("확인", null);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입 완룡!", Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입 취소해쓰", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater(); //메뉴 생성하는 것.
        minflater.inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.option_reset:
                edtPhNum.setText("");
                edtGen.setText("");
                Toast.makeText(getApplicationContext(), "초기화하였습니다.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option_end:
                finish();
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }



}