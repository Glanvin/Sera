package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import me.sera.app.R;
import me.sera.app.data.LoginModel;
import me.sera.app.events.LMEvent;
import me.sera.app.utils.State;

public class UILoginRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisui);
        try {
            wait(10000);
            startActivity(new Intent(UILoginRegister.this, UIHomePage.class));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}