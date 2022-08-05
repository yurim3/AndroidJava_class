package com.cookandroid.and0804_03_diarydb;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DiaryAdapter extends CursorAdapter {
    public DiaryAdapter(Context context, Cursor c, boolean autoRequery){
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.txtName);
        txtName.setText(cursor.getString(1));   //일기장 작성 날짜
    }
}