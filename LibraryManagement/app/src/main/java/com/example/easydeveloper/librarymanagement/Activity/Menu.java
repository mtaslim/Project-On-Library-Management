package com.example.easydeveloper.librarymanagement.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.easydeveloper.librarymanagement.R;

abstract class Menu extends AppCompatActivity
{
    ///Menu
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if(item.getItemId() == R.id.add)  {
            intent=new Intent(getApplicationContext(),BookAddUpdate.class);
        }
        /*else if(item.getItemId() == R.id.search)  {
           intent=new Intent(getApplicationContext(),SearchBooksActivity.class);
        }*/
        else if(item.getItemId() == R.id.search)  {
            intent=new Intent(getApplicationContext(),BookList.class);
        }
        else if(item.getItemId() == R.id.logout)  {
            intent=new Intent(getApplicationContext(),Login.class);
        }
        else{
            intent=new Intent(getApplicationContext(),BookAddUpdate.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    /// menu end
}
