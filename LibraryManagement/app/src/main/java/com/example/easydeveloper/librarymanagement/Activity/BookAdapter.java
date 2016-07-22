package com.example.easydeveloper.librarymanagement.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.easydeveloper.librarymanagement.Model.Book;
import com.example.easydeveloper.librarymanagement.R;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<Book>{
    private Context context;
    private ArrayList<Book>books;
    String bookName,writerName;

    private  class ViewHolder{
        TextView tvBookName;
        TextView tvWriterName;
    }

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, R.layout.list_row, books);
        this.context=context;
        this.bookName=bookName;
        this.writerName=writerName;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Book book=getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_row,null,true);
            viewHolder=new ViewHolder();
            viewHolder.tvBookName= (TextView) convertView.findViewById(R.id.tvBookName);
            viewHolder.tvWriterName= (TextView) convertView.findViewById(R.id.tvWriterName);
           convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tvBookName.setText(book.getBookName());
        viewHolder.tvWriterName.setText(book.getWriterName());

        return convertView;

    }
}
