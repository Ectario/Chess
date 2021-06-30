package com.ectario.objects;

public abstract class  Piece {

    protected Color color;
    protected PieceType pieceType;
    protected Move move;
    protected Board board;

    public Piece(PieceType pieceType, Color color, Board board){
        this.color = color;
        this.pieceType = pieceType;
        this.board = board;
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
