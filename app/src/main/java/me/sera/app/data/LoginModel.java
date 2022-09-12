package me.sera.app.data;

import android.util.Patterns;

import me.sera.app.events.LMEvent;
import me.sera.app.utils.State;

public class LoginModel implements LMEvent {

    //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
    private String username;
    private String email;
    private String password;
    private final int minPass = 5;

    @Override
    public void onRegister(String email, String username, String password) throws Exception {

    }

    @Override
    public void onLogin(String email, String password) {

    }

    private boolean isEmailValid(String email) {
        if(email == null) {
            return false;
        }

        if (email.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            return !email.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > minPass;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
