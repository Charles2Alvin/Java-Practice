package com.company;

public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);

    }
    @Override
    public void doCmd(String dir) {
        game.goRoom(dir);
    }
}