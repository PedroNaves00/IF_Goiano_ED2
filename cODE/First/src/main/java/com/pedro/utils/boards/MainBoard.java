package com.pedro.utils.boards;

public abstract class MainBoard {

    int lenght;
    int height;
    private Type type;
    private Mode mode;



    public MainBoard(int lenght, int height, Type type, Mode mode) {
        this.lenght = lenght;
        this.height = height;
        this.type = type;
        this.mode = mode;
    }
}
