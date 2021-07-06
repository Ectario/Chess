package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, Board board) {
        super(PieceType.ROOK, color, board);

        ArrayList movements = new ArrayList(); // The flag manage the line movements each update
        this.move = new Move(movements, board, List.of(Move.MoveFlag.LINE));
    }


}
