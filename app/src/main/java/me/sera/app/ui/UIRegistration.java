package me.sera.app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import es.dmoral.toasty.Toasty;
import me.sera.app.R;

public class UIRegistration extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_registration);

        MaterialButton register = (MaterialButton) findViewById(R.id.register);
        TextView oldUSER = (TextView) findViewById(R.id.textView4R);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatingUser();
            }
        });

        oldUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UIRegistration.this, UILogin.class));
                finish();
            }
        });
    }

    private void creatingUser() {

        String invalidE = getString(R.string.invalid_email);
        String invalidP = getString(R.string.invalid_password);
        TextView Remail = (TextView) findViewById(R.id.inputEMAILR);
        TextView Rpassword = (TextView) findViewById(R.id.inputPASSWORDR);
        TextView username = (TextView) findViewById(R.id.username);

        String email = Remail.getText().toString();
        String password = Rpassword.getText().toString();

        if(TextUtils.isEmpty(email)) {
            Remail.setError(invalidE);
            Remail.requestFocus();
        } else if(TextUtils.isEmpty(password)) {
            Rpassword.setError(invalidP);
            Rpassword.requestFocus();
        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toasty.success(UIRegistration.this, R.string.registration_success, Toasty.LENGTH_SHORT).show();
                        startActivity(new Intent(UIRegistration.this, UILogin.class));
                        finish();
                    } else {
                        Toasty.error(UIRegistration.this,  R.string.registration_failed + " " + task.getException().getMessage(), Toasty.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}