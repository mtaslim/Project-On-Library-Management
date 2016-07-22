package com.example.easydeveloper.librarymanagement.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easydeveloper.librarymanagement.R;
import com.example.easydeveloper.librarymanagement.UserInformation.User;

public class Login extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText etUser, etPassword;
    int userId;
    String user,password;
    User userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_management);

        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);

        userInfo = new User();

        sharedPreferences = getSharedPreferences("userLogin",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void Login(View view) {
        user = etUser.getText().toString();
        password = etPassword.getText().toString();
        userId = userInfo.Auth(user,password);

        if(userId>0){
            editor.putInt("userId",userId);
            editor.commit();  // Save the list.

            Intent intent = new Intent(getApplicationContext(),BookAddUpdate.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"User Information did not match",Toast.LENGTH_SHORT).show();
        }
    }


}
