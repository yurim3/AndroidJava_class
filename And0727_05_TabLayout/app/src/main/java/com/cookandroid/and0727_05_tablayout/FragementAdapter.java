package com.cookandroid.and0727_05_tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cookandroid.and0727_05_tablayout.BankData;
import com.cookandroid.and0727_05_tablayout.BankInput;
import com.cookandroid.and0727_05_tablayout.BankOutput;

import java.util.ArrayList;

public class FragementAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragList = new ArrayList<>();
    public FragementAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragList.add(new BankData());//0번 인텍스
        fragList.add(new BankInput());//1번 인텍스
        fragList.add(new BankOutput());//2번 인텍스
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {//position은 인덱스 번호
        return fragList.get(position);
    }
    @Override
    public int getCount() {
        return fragList.size();//페이지 개수 return
    }
}