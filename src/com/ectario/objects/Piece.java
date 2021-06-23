package com.ectario.objects;

enum PieceNames {
    King(0),
    Queen(9),
    Rook(5),
    Bishop(3),
    Knight(3),
    Pawn(1);


    public final int value;

    PieceNames(int value) {
        this.value = value;
    }
}

public class  Piece {
}
