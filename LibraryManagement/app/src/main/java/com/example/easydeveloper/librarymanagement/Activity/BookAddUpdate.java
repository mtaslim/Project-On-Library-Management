package com.example.easydeveloper.librarymanagement.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easydeveloper.librarymanagement.Database.BookTableSource;
import com.example.easydeveloper.librarymanagement.Model.Book;
import com.example.easydeveloper.librarymanagement.R;
import com.example.easydeveloper.librarymanagement.UserInformation.User;

import java.util.Calendar;

public class BookAddUpdate extends Menu {
    SharedPreferences sharedPreferences;
    int userId,id;
    User user;
    TextView tvPublishDate;
    EditText etBookName,etWriterName,etDescription;
    Button btnSave;
    BookTableSource bookTableSource;
    Book book;
    boolean status;
    String bookName,writerName,description,publishDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_entry);

        sharedPreferences = getSharedPreferences("userLogin",MODE_PRIVATE);
        userId=sharedPreferences.getInt("userId",0);

        user = new User();
        String userFullName = user.getUserInfo(userId,"userFullName");
        Toast.makeText(getApplicationContext(),"Thankyou "+userFullName+ "for using Library",Toast.LENGTH_SHORT).show();

        etBookName= (EditText) findViewById(R.id.etBookName);
        etWriterName= (EditText) findViewById(R.id.etWriterName);
        etDescription= (EditText) findViewById(R.id.etDescription);
        tvPublishDate = (TextView) findViewById(R.id.tvPublishDate);
        btnSave= (Button) findViewById(R.id.btnSave);


        id=getIntent().getIntExtra("id",0);
        bookTableSource =new BookTableSource(this);
        if(id>0){
            book = bookTableSource.getData(id);
            etBookName.setText(book.getBookName());
            etWriterName.setText(book.getWriterName());
            etDescription.setText(book.getDescription());
            tvPublishDate.setText(book.getPublishDate());
            btnSave.setText("update");
        }
    }

    public void showDatePicker(View v) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        tvPublishDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void SaveData(View view) {
        String msg="";
        bookName=etBookName.getText().toString().trim();
        writerName=etWriterName.getText().toString().trim();
        description=etDescription.getText().toString();
        publishDate=tvPublishDate.getText().toString();

        if((bookName != null && !bookName.isEmpty()) && writerName != null && !writerName.isEmpty()){
            book =new Book(userId,bookName,writerName,publishDate,description);

            if(id>0){
                status= bookTableSource.updateData(id, book);
                if(status==true)  msg="Record updated successfully";
                else  msg="Error: Record could not updated";

            }
            else{
                status= bookTableSource.addData(book);
                if(status==true)  msg="Record added successfully";
                else  msg="Error: Record could not added";
            }
        }

        if(msg!=""){
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),BookList.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Book name and Writer name is required", Toast.LENGTH_LONG).show();
        }



    }





}
