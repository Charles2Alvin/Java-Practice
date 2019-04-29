package com.company;

public class Handler {
    protected Game game = null;

    public Handler(Game game) {
        this.game = game;
    }
    public void doCmd(String cmd) {

    }
    public boolean isBye() {
        return false;
    }
}
