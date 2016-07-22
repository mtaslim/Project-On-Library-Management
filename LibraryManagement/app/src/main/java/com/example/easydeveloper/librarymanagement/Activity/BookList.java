package com.example.easydeveloper.librarymanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.easydeveloper.librarymanagement.Database.BookTableSource;
import com.example.easydeveloper.librarymanagement.Model.Book;
import com.example.easydeveloper.librarymanagement.R;

import java.util.ArrayList;

public class BookList extends Menu {
    ListView bookListView;
    BookTableSource bookTableSource;
    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);

        bookListView= (ListView) findViewById(R.id.bookList);
        bookTableSource =new BookTableSource(this);
        books = bookTableSource.getAllData();
        /*
        ArrayAdapter<Book> bookArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, books);
        bookListView.setAdapter(bookArrayAdapter);
        */

        ArrayAdapter<Book> bookArrayAdapter=new BookAdapter(getApplicationContext(), books);
        bookListView.setAdapter(bookArrayAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),BookDetails.class);
                intent.putExtra("id", books.get(i).getId());
                startActivity(intent);
            }
        });
    }

    public void edit(View view) {
        Intent saveIntent=new Intent(getApplicationContext(),BookAddUpdate.class);
        startActivity(saveIntent);
    }


}
