package me.sera.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import me.sera.app.MainActivity;
import me.sera.app.R;
import me.sera.app.events.RegisterEvent;
import me.sera.app.utils.State;

public class UIRegistration extends AppCompatActivity implements RegisterEvent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisui);

        TextView user = findViewById(R.id.ruser);
        TextView pass = findViewById(R.id.rpass);

        MaterialButton regis = findViewById(R.id.regis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((user.getText().toString().isEmpty() && pass.getText().toString().isEmpty())) {
                    onRegister(user.getText().toString(), State.FAILED);
                }else {
                    onRegister(user.getText().toString(), State.COMPLETE);
                }
            }
        });
    }

    @Override
    public void onRegister(String email, String username, String password) {

    }

    @Override
    public void onRegister(String args, State state) {

        State s = state;
        switch (s) {
            case COMPLETE:
                Toast.makeText(this, "Registered as " + args, Toast.LENGTH_SHORT).show();
                finish();
                break;
            case FAILED:
                Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show();
                break;
            case aRegistered:
                Toast.makeText(this, "User Already registered", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
    }

    @Override
    public void onLogin(String email, String password) {

    }
}