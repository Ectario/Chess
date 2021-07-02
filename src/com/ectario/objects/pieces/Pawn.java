package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(PieceType pieceType, Color color, Board board) {
        super(pieceType, color, board);
        List<List<Integer>> movement = List.of(
                List.of(1,0) //TODO : Manage the side , if the player is in the top, then the (1,0) need to be (-1,0) + In the beginning (2,0)
        );
        this.move = new Move(movement, board);
    }
}
