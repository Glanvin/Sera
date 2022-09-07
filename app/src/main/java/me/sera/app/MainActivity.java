package me.sera.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import me.sera.app.ui.UIHomePage;
import me.sera.app.ui.UIRegistration;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        errands();

    }


    private void errands() {

        TextView user = findViewById(R.id.user);
        TextView pass = findViewById(R.id.pass);

        MaterialButton regis = findViewById(R.id.regist);
        MaterialButton login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equalsIgnoreCase("Admin")  && pass.getText().toString().equals("admin")) {
                    startActivity(new Intent(MainActivity.this, UIHomePage.class));

                }else if(user.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Missing field(s)!", Toast.LENGTH_SHORT).show();
                    user.setText("");
                    pass.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Input(s) not valid in!", Toast.LENGTH_SHORT).show();
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