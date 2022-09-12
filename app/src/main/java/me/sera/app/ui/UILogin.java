package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import me.sera.app.R;

public class UILogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_login);
        newErrands();

    }

    private void newErrands() {
        TextView newUSER = (TextView) findViewById(R.id.textView4);

        newUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UILogin.this, UIRegistration.class));
                finish();
            }
        });

    }

}