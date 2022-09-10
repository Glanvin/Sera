package me.sera.app.events;

import me.sera.app.utils.State;

public interface LMEvent {

    public void onRegister(String email, String username, String password) throws Exception;
    public void onLogin(String email, String password);

}
