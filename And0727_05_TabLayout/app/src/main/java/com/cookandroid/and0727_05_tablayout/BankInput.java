package com.cookandroid.and0727_05_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.and0727_05_tablayout.R;

public class BankInput extends Fragment {
    Button btnInputOk;    EditText edtInput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_input, container, false);
        btnInputOk = v.findViewById(R.id.btnInputOk);
        edtInput = v.findViewById(R.id.edtInput);
        btnInputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInput.getText().toString());
                com.cookandroid.and0727_05_tablayout.BankData.data += n;
                com.cookandroid.and0727_05_tablayout.BankData.txtData.setText("잔액:"+ com.cookandroid.and0727_05_tablayout.BankData.data+"원");
            }
        });
        return v;
    }
}