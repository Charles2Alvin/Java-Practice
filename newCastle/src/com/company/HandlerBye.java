package com.company;

public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("感谢您的光临。再见！");
    }
    public boolean isBye() {
        return true;
    }
}
