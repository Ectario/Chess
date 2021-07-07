package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, Board board) {
        super(PieceType.QUEEN, color, board);
        ArrayList<List<Integer>> movements = new ArrayList<>(); // The flag manage the line movements each update
        this.move = new Move(movements, board, List.of(Move.MoveFlag.DIAGO, Move.MoveFlag.LINE));
    }
}
