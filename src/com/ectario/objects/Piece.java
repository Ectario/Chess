package com.ectario.objects;

import java.util.List;

public class  Piece {

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
        String namePiece;
        if(pieceType.name() == "KNIGHT")
        {
            namePiece = "N";
        } else namePiece = String.valueOf(pieceType.name().charAt(0));
        return String.valueOf(this.color.name().charAt(0) + namePiece);
    }

    public void movePiece(List<Integer> currentPosition, List<Integer> targetedPosition){
        if(move.isPossible(currentPosition, targetedPosition)){
            int currentPlace = board.tuplePosToIntPlace(currentPosition);
            int targetedPlace = board.tuplePosToIntPlace(targetedPosition);
            // The old tile become an Empty Tile and the target become an Occupied Tile
            Tile oldTile = new Tile.EmptyTile(currentPlace);
            Tile targetedTile = new Tile.OccupiedTile(targetedPlace, this);
            try {
                board.setTile(oldTile);
                board.setTile(targetedTile);
            } catch (Board.TilePlacementException e) {
                e.printStackTrace();
            }
        }
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
