package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;
import me.sera.app.R;
import me.sera.app.utils.SeraAuthModel;

public class UILogin extends AppCompatActivity {


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_login);

        auth = FirebaseAuth.getInstance();

        String adminUSER = getString(R.string.tempname);
        String adminPASS = getString(R.string.temppass);

        TextView newUSER = (TextView) findViewById(R.id.textView4);

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
                onLogin();
            }
        });

    }

    private void onLogin() {
        String invalidE = getString(R.string.invalid_email);
        String invalidP = getString(R.string.invalid_password);

        TextView Lemail = (TextView) findViewById(R.id.inputEMAIL);
        TextView Lpassword = (TextView) findViewById(R.id.inputPASSWORD);

        String email = Lemail.getText().toString();
        String password = Lpassword.getText().toString();

        SeraAuthModel sam = new SeraAuthModel();

        sam.signInWithEmail(UILogin.this, email, password);

    }

}