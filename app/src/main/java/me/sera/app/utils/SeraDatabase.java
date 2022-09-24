package me.sera.app.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SeraDatabase {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Map<String, Object> user = new HashMap<>();

    public SeraDatabase() {
    }

    public void addUserToDatabase(@NonNull String username, @NonNull String email, Authority authority) {
        user.put("name", username);
        user.put("email", email);
        user.put("authority", authority.toString().toLowerCase());
        db.collection("users").add(user)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Log.d("stub", "Added user to database");
                        } else {
                            Log.w("stub", "Failed to add user to database");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("stub", "Error adding document", e);
                    }
                });

    }

    public void addUserToDatabaseDefault(@NonNull String username, @NonNull String email) {
        user.put("name", username);
        user.put("email", email);
        user.put("authority", "default");
        db.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Log.d("stub", "Added user to database");
                        } else {
                            Log.w("stub", "Failed to add user to database");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("stub", "Error adding document", e);
                    }
                });
    }
}
