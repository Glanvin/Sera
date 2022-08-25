package me.sera.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import me.sera.app.ui.RegisUI;
import me.sera.app.utils.FileHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.user);
        TextView pass = findViewById(R.id.pass);

        MaterialButton regis = findViewById(R.id.regis);
        MaterialButton login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().isEmpty() && pass.getText().toString().isEmpty())
                  Toast.makeText(MainActivity.this, "Input Field(s) are empty!", Toast.LENGTH_SHORT).show();
                //TODO: Check if user is registered
                if(user.getText().toString() == FileHandler.getInstance().onRead("username.txt") && pass.getText().toString() == FileHandler.getInstance().onRead("password.txt"))
                    Toast.makeText(MainActivity.this, "Sup!", Toast.LENGTH_LONG).show();;
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisUI.class));
            }
        });
    }
}