package me.sera.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import me.sera.app.R;
import me.sera.app.utils.SeraAuthModel;
import me.sera.app.utils.SeraDatabase;

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

        /*String invalidE = getString(R.string.invalid_email);
        String invalidP = getString(R.string.invalid_password);
        String Rerror = getString(R.string.registration_failed);*/
        TextView Remail = (TextView) findViewById(R.id.inputEMAILR);
        TextView Rpassword = (TextView) findViewById(R.id.inputPASSWORDR);
        TextView Rusername = (TextView) findViewById(R.id.inputUSERNAME);

        String email = Remail.getText().toString();
        String password = Rpassword.getText().toString();
        String username = Rusername.getText().toString();

        SeraAuthModel um = new SeraAuthModel();

        if(TextUtils.isEmpty(username)) {
            Rusername.setError("Username cannot be blank!");
        } else {
            um.CreateUser(UIRegistration.this, email, password, username);
            startActivity(new Intent(UIRegistration.this, UILogin.class));
        }
    }
}