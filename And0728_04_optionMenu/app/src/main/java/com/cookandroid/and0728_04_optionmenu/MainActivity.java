package com.cookandroid.and0728_04_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.and0728_04_optionmenu.R;

public class MainActivity extends AppCompatActivity {
    TextView txtName, txtTel; //추가되는 이름, 전번 부분
    Button btnEnd; //종료 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        txtTel = findViewById(R.id.txtTel);
        btnEnd = findViewById(R.id.btnEnd);

        btnEnd.setOnClickListener(new View.OnClickListener() { //종료 버튼 누르면 종료 기능
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_option, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optTelAdd:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화 번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null) ;
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText dlgName = dlgView.findViewById(R.id.edtName);
                        EditText dlgTel = dlgView.findViewById(R.id.edtTel);
                        String str = txtName.getText().toString() + dlgName.getText().toString() + "\n";
                        String str2 = txtTel.getText().toString() + dlgTel.getText().toString() + "\n";
                        txtName.setText(str);
                        txtTel.setText(str2);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            case R.id.itemBlue:
                    txtName.setTextColor(Color.BLUE);
                    txtTel.setTextColor(Color.BLUE);
                    return true;

                case R.id.itmeGreen:
                    txtName.setTextColor(Color.GREEN);
                    txtTel.setTextColor(Color.GREEN);
                    return true;

                case R.id.itmeBas:
                    txtName.setTextColor(Color.BLACK);
                    txtTel.setTextColor(Color.BLACK);
                    return true;

                default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                    return false;
            }
        }
    }