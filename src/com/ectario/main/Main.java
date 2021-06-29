package com.ectario.main;

import com.ectario.objects.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        Piece pieceTest = new Piece(PieceType.KNIGHT, Color.WHITE);
        Tile tile = new Tile.OccupiedTile(board.tuplePosToIntPlace(List.of(2, 3)), pieceTest);
        board.changeTile(tile, List.of(2, 3));

        board.printBoard();
    }
}
