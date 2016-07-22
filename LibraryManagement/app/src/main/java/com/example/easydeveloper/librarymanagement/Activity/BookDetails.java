package com.example.easydeveloper.librarymanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.easydeveloper.librarymanagement.Database.BookTableSource;
import com.example.easydeveloper.librarymanagement.Model.Book;
import com.example.easydeveloper.librarymanagement.R;
import com.example.easydeveloper.librarymanagement.UserInformation.User;

public class BookDetails extends Menu {
    BookTableSource bookTableSource;
    TextView tvUser;
    int id;
    TextView tvBookName,tvWriterName,tvPublishDate,tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_book);

        tvUser= (TextView) findViewById(R.id.tvUser);
        tvBookName= (TextView) findViewById(R.id.tvBookName);
        tvWriterName= (TextView) findViewById(R.id.tvWriterName);
        tvPublishDate= (TextView) findViewById(R.id.tvPublishDate);
        tvDescription= (TextView) findViewById(R.id.tvDescription);

        bookTableSource =new BookTableSource(this);
        id=getIntent().getIntExtra("id",0);
        Book book = bookTableSource.getData(id);

        User u = new User();
        String userName = u.getUserInfo(book.getUserId(),"userName");

        tvUser.setText(userName);
        tvBookName.setText(book.getBookName());
        tvWriterName.setText(book.getWriterName());
        tvPublishDate.setText(book.getPublishDate());
        tvDescription.setText(book.getDescription());
    }

    public void update(View view) {
        Intent updateIntent=new Intent(getApplicationContext(),BookAddUpdate.class);
        updateIntent.putExtra("id",id);
        startActivity(updateIntent);
    }

    public void delete(View view) {
        bookTableSource.deleteData(id);
        Intent homeIntent=new Intent(getApplicationContext(),BookList.class);
        startActivity(homeIntent);
    }


}
