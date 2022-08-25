package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import me.sera.app.*;

public class UIlogin extends AppCompatActivity {

    public String email;
    public String password;
    public String uniqueID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uilogin);

    }

}