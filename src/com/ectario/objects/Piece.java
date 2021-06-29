package com.ectario.objects;

public class  Piece {

    protected Color color;
    protected PieceType pieceType;
    protected Move move;

    public Piece(PieceType pieceType, Color color){
        this.color = color;
        this.pieceType = pieceType;
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
