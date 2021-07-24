package com.ectario.main;

import com.ectario.tools.*;
import com.ectario.objects.*;
import com.ectario.objects.pieces.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static Board board = new Board();

    public static void main(String[] args) {
        Piece testPiece = new Rook(Color.BLACK, board);
        Tile tile = new Tile.OccupiedTile(List.of(1,1), testPiece);

        try {
            board.setTile(tile);
        } catch (Board.TilePlacementException e) {
            e.printStackTrace();
        }

//        //Put WK where the testPiece can move
//
//        tile.getPiece().getMove().update(tile.getPosition());
//        for(List<Integer> tmpPos : tile.getPiece().getMove().getPossibleTargets()){
//            Piece tmpPiece = new King(Color.WHITE, board);
//            Tile newTmpTile = new Tile.OccupiedTile(tmpPos, tmpPiece);
//            try {
//                board.setTile(newTmpTile);
//            } catch (Board.TilePlacementException e) {
//                e.printStackTrace();
//            }
//        }
//        board.printBoard();
//
//        // Play randomly
//        tile.getPiece().getMove().update(tile.getPosition());
//        tile.getPiece().movePiece(tile.getPosition(), tile.getPiece().getMove().getPossibleTargets().get(Tools.randrange(0,
//                tile.getPiece().getMove().getPossibleTargets().size())));

        board.printBoard();

    }
}
