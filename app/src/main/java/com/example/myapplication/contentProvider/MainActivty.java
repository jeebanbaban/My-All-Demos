package com.example.myapplication.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivty extends AppCompatActivity {

    private EditText etName,etPhone;
    private TextView tvContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activty);

        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        tvContactDetails=findViewById(R.id.tvContactDetails);

    }

    public void addContactDetails(View view) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBOpenHelper.CONTACT_NAME,etName.getText().toString());
        contentValues.put(DBOpenHelper.CONTACT_PHONE,etPhone.getText().toString());

        Uri uri=getContentResolver().insert(ContactsProvider.CONTENT_URI,contentValues);
    }

    public void showContactDetails(View view) {
        Cursor cursor=getContentResolver().query(ContactsProvider.CONTENT_URI,null,null,null,null);

        System.out.println("cursor==="+cursor);

        if (cursor.moveToFirst()){
            StringBuilder stringBuilder=new StringBuilder();

            while (!cursor.isAfterLast()){

                stringBuilder.append("\n"+cursor.getString(cursor.getColumnIndex(DBOpenHelper.CONTACT_ID))+
                        "-"+ cursor.getString(cursor.getColumnIndex(DBOpenHelper.CONTACT_NAME))+
                        "-"+cursor.getString(cursor.getColumnIndex(DBOpenHelper.CONTACT_PHONE)));
                cursor.moveToNext();
            }

            tvContactDetails.setText(stringBuilder);
        }else {
            tvContactDetails.setText("No Contact Found");
        }

    }

   /* public void UpdateContactDetails(View view) {

        ContentValues contentValues=new ContentValues();
        contentValues.put(DBOpenHelper.CONTACT_NAME,etName.getText().toString());
        contentValues.put(DBOpenHelper.CONTACT_PHONE,etPhone.getText().toString());

        Uri uri=getContentResolver().insert(ContactsProvider.CONTENT_URI,contentValues);
        getContentResolver().update(ContactsProvider.CONTENT_URI,contentValues,null,null);

        System.out.println("@@@@@@@@@@@@@@@@");
        System.out.println("INSERT URI=="+uri);
        System.out.println("@@@@@@@@@@@@@@@@");
    }*/
}
