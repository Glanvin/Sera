package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import me.sera.app.R;

public class UILoginRegister extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisui);
        newErrands();

    }

    private void newErrands() {
        String passwordTOAST = getString(R.string.invalid_password);
        String tempName = getString(R.string.tempname);

        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.pass);

        MaterialButton login = (MaterialButton) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().trim().isEmpty() && email.getText().toString().trim().isEmpty()) {
                    Toast.makeText(UILoginRegister.this, "Empty fields", Toast.LENGTH_SHORT).show();
                    email.getText().clear();
                    password.getText().clear();
                    return;
                }
                if (password.getText().toString().trim().length() >= 5
                        && email.getText().toString().trim().equalsIgnoreCase(tempName)) {
                    startActivity(new Intent(UILoginRegister.this, UIHomePage.class));
                    password.getText().clear();
                    email.getText().clear();
                } else {
                    Toast.makeText(UILoginRegister.this, passwordTOAST + " or email is invalid", Toast.LENGTH_SHORT).show();
                    password.getText().clear();
                }
            }
        });
    }

}