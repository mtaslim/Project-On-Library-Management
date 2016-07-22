package com.example.easydeveloper.librarymanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.easydeveloper.librarymanagement.Model.Book;

import java.util.ArrayList;


public class BookTableSource {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Book book;

    public BookTableSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }

    public boolean addData(Book book){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_USER_ID, book.getUserId());
        contentValues.put(DatabaseHelper.COL_BOOK_NAME, book.getBookName());
        contentValues.put(DatabaseHelper.COL_WRITER_NAME, book.getWriterName());
        contentValues.put(DatabaseHelper.COL_PUBLISH_DATE, book.getPublishDate());
        contentValues.put(DatabaseHelper.COL_DESCRIPTION, book.getDescription());

        long inserted=database.insert(DatabaseHelper.TABLE_BOOK,null,contentValues);
        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }
    }

    public Book getData(int id){
        this.open();

        Cursor cursor=database.query(DatabaseHelper.TABLE_BOOK,new String[]{DatabaseHelper.COL_ID,DatabaseHelper.COL_USER_ID,DatabaseHelper.COL_BOOK_NAME,DatabaseHelper.COL_WRITER_NAME,DatabaseHelper.COL_PUBLISH_DATE,DatabaseHelper.COL_DESCRIPTION},DatabaseHelper.COL_ID+" = "+id,null,null,null,null);

        cursor.moveToFirst();
        int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        int mUserId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_USER_ID));
        String mBookName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_BOOK_NAME));
        String mWriterName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_WRITER_NAME));
        String mPublishDate=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PUBLISH_DATE));
        String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DESCRIPTION));

        cursor.close();
        book =new Book(mId,mUserId,mBookName,mWriterName,mPublishDate,mDescription);
        this.close();
        return book;
    }

    public ArrayList<Book>getAllData(){
        ArrayList<Book> books =new ArrayList<>();
        this.open();
        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_BOOK+" ORDER BY "+DatabaseHelper.COL_ID+" DESC",null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();

            for(int i=0;i<cursor.getCount();i++){
                int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                int mUserId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_USER_ID));
                String mBookName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_BOOK_NAME));
                String mWriterName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_WRITER_NAME));
                String mPublishDate=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PUBLISH_DATE));
                String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DESCRIPTION));


                book =new Book(mId,mUserId,mBookName,mWriterName,mPublishDate,mDescription);
                books.add(book);
               cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return books;
    }

    public boolean updateData(int id,Book book){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_USER_ID, book.getUserId());
        contentValues.put(DatabaseHelper.COL_BOOK_NAME, book.getBookName());
        contentValues.put(DatabaseHelper.COL_WRITER_NAME, book.getWriterName());
        contentValues.put(DatabaseHelper.COL_PUBLISH_DATE, book.getPublishDate());
        contentValues.put(DatabaseHelper.COL_DESCRIPTION, book.getDescription());
        int update=database.update(DatabaseHelper.TABLE_BOOK,contentValues,DatabaseHelper.COL_ID+" = "+id,null);
        this.close();

        if(update>0){
            return true;

        }else {
            return false;
        }

    }

    public boolean deleteData(int id){
        this.open();

        int deleted=database.delete(DatabaseHelper.TABLE_BOOK,DatabaseHelper.COL_ID+" = "+id,null);

        this.close();

        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }



}
