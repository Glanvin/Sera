package me.sera.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import me.sera.app.ui.*;
import me.sera.app.ui.fragments.*;
import me.sera.app.utils.SeraViewPagerAdapter;

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

                }else {
                    Toast.makeText(MainActivity.this, "Empty field(s)!", Toast.LENGTH_SHORT).show();
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