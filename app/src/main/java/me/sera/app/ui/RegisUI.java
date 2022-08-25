package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import me.sera.app.MainActivity;
import me.sera.app.R;
import me.sera.app.utils.FileHandler;

public class RegisUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisui);

        TextView user = findViewById(R.id.user);
        TextView pass = findViewById(R.id.pass);

        MaterialButton regis = findViewById(R.id.regis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().isEmpty() && pass.getText().toString().isEmpty()) {
                    Toast.makeText(RegisUI.this, "Input Field(s) are empty!", Toast.LENGTH_SHORT).show();

                }else {
                    FileHandler.getInstance().onWrite("username", user.getText().toString(), ".txt");
                    FileHandler.getInstance().onWrite("password", pass.getText().toString(), ".txt");
                }
            }
        });
    }
}