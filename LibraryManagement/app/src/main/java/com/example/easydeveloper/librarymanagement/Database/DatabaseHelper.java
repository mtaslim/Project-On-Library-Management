package com.example.easydeveloper.librarymanagement.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME="library";
    static final int DATABASE_VERSION=2;
    static final String TABLE_BOOK="book_info";

    static final String COL_ID="id";
    static final String COL_USER_ID="user_id";
    static final String COL_BOOK_NAME="book_name";
    static final String COL_WRITER_NAME="writer_name";
    static final String COL_PUBLISH_DATE="publish_date";
    static final String COL_DESCRIPTION="description";

    static final String CREATE_TABLE="create table "+TABLE_BOOK+"( "+COL_ID+" integer primary key, "+COL_USER_ID+" INTEGER, "+ COL_BOOK_NAME+" text, "+
            COL_WRITER_NAME+" text, "+ COL_PUBLISH_DATE+" text, "+ COL_DESCRIPTION+" text);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);
        onCreate(sqLiteDatabase);
    }
}
