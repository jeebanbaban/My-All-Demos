package com.example.myapplication.contentProvider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
                R.layout.contact_list_item,parent,false );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        String contactName = cursor.getString(
                cursor.getColumnIndex(DBOpenHelper.CONTACT_NAME));
        String contactPhone = cursor.getString(
                cursor.getColumnIndex(DBOpenHelper.CONTACT_PHONE));

        TextView nameTextView =view.findViewById(R.id.nameTextView);
        TextView phoneTextView =view.findViewById(R.id.phoneTextView);

        nameTextView.setText(contactName);
        phoneTextView.setText(contactPhone);

    }
}
