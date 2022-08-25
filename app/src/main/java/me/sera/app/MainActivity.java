package me.sera.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import me.sera.app.ui.UIChatHome;
import me.sera.app.ui.UIRegistration;
import me.sera.app.utils.FileHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = (TextView) findViewById(R.id.user);
        TextView pass = (TextView) findViewById(R.id.pass);

        MaterialButton regis = (MaterialButton) findViewById(R.id.regis);
        MaterialButton login = (MaterialButton) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals("Admin") && pass.getText().toString().equals("admin")) {
                    startActivity(new Intent(MainActivity.this, UIChatHome.class));
                    Toast.makeText(MainActivity.this, "Logged!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UIRegistration.class));
            }
        });
    }
}