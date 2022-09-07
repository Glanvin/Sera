package me.sera.app.events;

import me.sera.app.utils.State;

public interface RegisterEvent {

    public void onRegister(String email, String username, String password);
    public void onRegister(String args, State state);
    public void onLogin(String email, String password);

}
