package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import es.dmoral.toasty.Toasty;
import me.sera.app.R;

public class UILogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_login);
        newErrands();

    }

    private void newErrands() {

        String adminUSER = getString(R.string.tempname);
        String adminPASS = getString(R.string.temppass);

        TextView newUSER = (TextView) findViewById(R.id.textView4);
        TextView email = (TextView) findViewById(R.id.inputEMAIL);
        TextView password = (TextView) findViewById(R.id.inputPASSWORD);

        MaterialButton login = (MaterialButton) findViewById(R.id.login);

        newUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UILogin.this, UIRegistration.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().trim().isEmpty() && email.getText().toString().trim().isEmpty()) {
                    Toasty.error(UILogin.this, R.string.login_failed, Toasty.LENGTH_SHORT).show();
                    return;
                } else if(!(password.getText().toString().trim().equalsIgnoreCase(adminPASS) && email.getText().toString().trim().equalsIgnoreCase(adminUSER))) {
                    Toasty.error(UILogin.this, R.string.input_invalid, Toasty.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().trim().contains(adminPASS) && email.getText().toString().trim().equalsIgnoreCase(adminUSER)) {
                    startActivity(new Intent(UILogin.this, UIHomePage.class));
                    finish();
                }
            }
        });

    }

}