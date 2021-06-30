package com.ectario.main;

import com.ectario.objects.*;

import java.util.List;

public class Main {
    private static final Board board = new Board();

    public static void main(String[] args) {

//        Piece pieceTest = new Piece(PieceType.KNIGHT, Color.WHITE);
//        Tile tile = new Tile.OccupiedTile(board.tuplePosToIntPlace(List.of(2, 3)), pieceTest);
//
//        try {
//            board.changeTile(tile, List.of(2, 4));
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }

        board.printBoard();
    }
}
