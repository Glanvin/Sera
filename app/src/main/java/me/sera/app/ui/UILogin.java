package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

        if(TextUtils.isEmpty(email)) {
            Lemail.setError(invalidE);
            Lemail.requestFocus();
        } else if(TextUtils.isEmpty(password)) {
            Lpassword.setError(invalidP);
            Lpassword.requestFocus();
        } else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        startActivity(new Intent(UILogin.this, UIHomePage.class));
                        Toasty.success(UILogin.this, R.string.login_success, Toasty.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toasty.error(UILogin.this, R.string.login_failed + " " + task.getException().getMessage(), Toasty.LENGTH_SHORT).show();;
                    }
                }
            });
        }

    }

}