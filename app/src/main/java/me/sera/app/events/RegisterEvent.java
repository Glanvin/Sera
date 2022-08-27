package me.sera.app.events;

import me.sera.app.utils.State;

public interface RegisterEvent {

    public void onRegister(String args, State state);

}
