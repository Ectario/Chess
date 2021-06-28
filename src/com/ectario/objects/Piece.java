package com.ectario.objects;

enum PieceType {
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

enum Color {
    WHITE,
    BLACK
}

public abstract class  Piece {

    protected Color color;
    protected PieceType pieceType;
    protected Move move;

    Piece(PieceType pPieceType, Color pColor){
        this.color = pColor;
        this.pieceType = pPieceType;
    }

    @Override
    public String toString(){
        return pieceType.name();
    }

    public String toStringAbbreviation(){
        //Return the first letter of the name of the piece + First letter of the color
        return this.color.name().charAt(0) + String.valueOf(pieceType.name().charAt(0));
    }

    public Move getMove() {
        return move;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Color getColor() {
        return color;
    }
}
