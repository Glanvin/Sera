package me.sera.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import es.dmoral.toasty.Toasty;
import me.sera.app.ui.UIHomePage;
import me.sera.app.ui.UILogin;
import me.sera.app.ui.UIRegistration;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if(user == null) {
            startActivity(new Intent(MainActivity.this, UIRegistration.class));
            finish();
        }else if(user != null) {
            startActivity(new Intent(MainActivity.this, UIHomePage.class));
            Toasty.normal(MainActivity.this, "User isn't null!", Toasty.LENGTH_SHORT).show();
            finish();
        }
    }
}