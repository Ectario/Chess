package com.ectario.main;

import com.ectario.tools.*;
import com.ectario.objects.*;
import com.ectario.objects.pieces.*;

import java.util.List;


public class Main {
    private static Board board = new Board();

    public static void main(String[] args) {
        Piece knight = new Pawn(Color.BLACK, board);
        Tile tile = new Tile.OccupiedTile(board.tuplePosToIntPlace(List.of(5,5)), knight);

        try {
            board.setTile(tile);
        } catch (Board.TilePlacementException e) {
            e.printStackTrace();
        }

        board.printBoard();

        tile.getPiece().getMove().update(board.intPlaceToTuplePos(tile.getPlace()));
        tile.getPiece().movePiece(board.intPlaceToTuplePos(tile.getPlace()), tile.getPiece().getMove().getPossibleTargets().get(Tools.randrange(0,
                tile.getPiece().getMove().getPossibleTargets().size())));

        board.printBoard();


    }
}
