package me.sera.app.data;

import me.sera.app.events.LMEvent;
import me.sera.app.utils.State;

public class LoginModel implements LMEvent {

    public String username;
    public String email;
    public String password;

    @Override
    public void onRegister(String email, String username, String password) throws Exception {

    }

    @Override
    public void onLogin(String email, String password) {

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
