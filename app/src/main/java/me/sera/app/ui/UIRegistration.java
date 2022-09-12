package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.sera.app.R;

public class UIRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_registration);
        doThis();
    }

    private void doThis() {
        TextView oldUSER = (TextView) findViewById(R.id.textView4R);

        oldUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UIRegistration.this, UILogin.class));
                finish();
            }
        });
    }
}