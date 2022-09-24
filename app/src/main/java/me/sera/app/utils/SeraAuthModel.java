package me.sera.app.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;
import me.sera.app.ui.UIHomePage;

public class SeraAuthModel {


    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private SeraDatabase sdb = new SeraDatabase();

    public String username;
    public String email;

    public SeraAuthModel() {
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        username = username;
    }

    public final void CreateUser(@NonNull Context context, String email, String password, String username) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        SeraDatabase sdb = new SeraDatabase();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                try {
                    if (task.isSuccessful()) {
                        Toasty.success(context, "Registration complete!").show();
                    } else {
                        Toasty.error(context, "The task has failed for some reason!").show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        sdb.addUserToDatabase(username, email, Authority.ADMIN);
    }

    public void signInWithEmail(Context context, @NonNull String email, @NonNull String password,) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                Toasty.success(context, "Login complete!").show();
                            } else {
                                Toasty.error(context, "The task has failed for some reason!").show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("stub", "Login Failed unexpected!");
                    }
                });
    }
}
