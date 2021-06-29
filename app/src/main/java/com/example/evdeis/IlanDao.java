package com.example.evdeis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IlanDao  extends SQLiteOpenHelper {
    private static final String VERITABANI_ADI = "kayıtlar";
    private static final int SURUM = 1;

    public IlanDao(Context c) {

        super(c, VERITABANI_ADI, null, SURUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  ilan(baslik TEXT,aciklama TEXT,ucret INTEGER );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ilan");
        onCreate(db);
    }
}
