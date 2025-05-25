package com.example.travelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
    private SQLiteHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    // 注册用户
    public long registerUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PHONE, user.getPhone());
        values.put(SQLiteHelper.COLUMN_PASSWORD, user.getPassword());
        long result = db.insert(SQLiteHelper.TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // 验证用户登录
    public boolean validateUser(String phone, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = { SQLiteHelper.COLUMN_ID };
        String selection = SQLiteHelper.COLUMN_PHONE + " = ? AND " +
                SQLiteHelper.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = { phone, password };
        Cursor cursor = db.query(
                SQLiteHelper.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        boolean isValid = cursor.moveToFirst();
        cursor.close();
        db.close();
        return isValid;
    }

    // 检查手机号是否已注册
    public boolean checkPhoneExists(String phone) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = { SQLiteHelper.COLUMN_ID };
        String selection = SQLiteHelper.COLUMN_PHONE + " = ?";
        String[] selectionArgs = { phone };
        Cursor cursor = db.query(
                SQLiteHelper.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }
}