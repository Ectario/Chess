package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color, Board board) {
        super(PieceType.BISHOP, color, board);

        ArrayList<List<Integer>> movements = new ArrayList<>(); // The flag manage the diago movements each update
        this.move = new Move(movements, board, List.of(Move.MoveFlag.DIAGO));
    }
}
