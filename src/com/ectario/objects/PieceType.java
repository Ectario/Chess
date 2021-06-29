package com.ectario.objects;

public enum PieceType {
    KING(0),
    QUEEN(9),
    ROOK(5),
    BISHOP(3),
    KNIGHT(3),
    PAWN(1);

    public final int value;

    PieceType(int value) {
        this.value = value;
    }
}
