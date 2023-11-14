package com.pedro.utils.boards;

public class ChessBoard extends MainBoard {
    public ChessBoard(int lenght, int height, Type type, Mode mode) {
        super(lenght, height, type, mode);

    }


    private void setDefaultGameConfig() {
        super.height = super.lenght = 8;
    }



}
