package com.ectario.main;

import com.ectario.objects.*;
import com.ectario.objects.pieces.Knight;

import java.util.List;

public class Main {
    private static Board board = new Board();

    public static void main(String[] args) {
        Piece knight = new Knight(Color.WHITE, board);
        Tile tile = new Tile.OccupiedTile(board.tuplePosToIntPlace(List.of(0,0)), knight);

        try {
            board.setTile(tile);
        } catch (Board.TilePlacementException e) {
            e.printStackTrace();
        }

        board.printBoard();

        tile.getPiece().getMove().update(board.intPlaceToTuplePos(tile.getPlace()));
        tile.getPiece().movePiece(board.intPlaceToTuplePos(tile.getPlace()), tile.getPiece().getMove().getPossibleTargets().get(0));

        board.printBoard();

        System.out.println(tile.getPiece().getMove().getPossibleTargets());
    }
}
