package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color, Board board) {
        super(PieceType.PAWN, color, board);
        List<List<Integer>> movements = List.of(
                List.of(0,1) //TODO : In the beginning (2,0)
        );

        if(color.name().equals("WHITE")){
            movements = this.whiteSideMovement(movements);
        }

        this.move = new Move(movements, board);
    }
}
