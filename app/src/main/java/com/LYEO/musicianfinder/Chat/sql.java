package com.LYEO.musicianfinder.Chat;/*
 * created by yisrael bar
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sql extends SQLiteOpenHelper {
    public sql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String query =("create table if not exists t1(chatName text) ");
            db.execSQL(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddChatName (String w){
        try {
            SQLiteDatabase sd=getWritableDatabase();
            ContentValues cv1=new ContentValues();
            cv1.put("chatName",w);
            sd.insert("t1",null,cv1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showChatNames(){
        try {
            String query = "select * from t1";
            SQLiteDatabase db=getWritableDatabase();
            Cursor c1;
            c1=db.rawQuery(query,null);
            if (c1.moveToFirst()){
                do {
                    String w;
                    w=c1.getString(0);
                    Rooms.chatsList.add(w);
                }while (c1.moveToNext());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
