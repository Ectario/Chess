package com.ectario.objects;

import java.util.List;
import java.util.stream.Collectors;

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
        //Return the first letter of the color + the first letter of the name of the piece
        String namePiece;
        if(pieceType.name().equals("KNIGHT"))
        {
            namePiece = "N";
        } else namePiece = String.valueOf(pieceType.name().charAt(0));
        return String.valueOf(this.color.name().charAt(0)) + namePiece;
    }

    public void movePiece(List<Integer> currentPosition, List<Integer> targetedPosition){
        if(move.isPossible(currentPosition, targetedPosition)){
            // The old tile become an Empty Tile and the target become an Occupied Tile
            Tile oldTile = new Tile.EmptyTile(currentPosition);
            Tile targetedTile = new Tile.OccupiedTile(targetedPosition, this);
            try {
                board.setTile(oldTile);
                board.setTile(targetedTile);
            } catch (Board.TilePlacementException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("\nMove not authorized !\n");
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

    protected List<List<Integer>> whiteSideMovement(List<List<Integer>> movements){
        // Reverse the movements for the white side
        return movements.stream().map(elt -> List.of(-elt.get(0), -elt.get(1))).collect(Collectors.toList());
    }
}
