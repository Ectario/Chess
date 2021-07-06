package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class King extends Piece {
    public King(Color color, Board board) {
        super(PieceType.KING, color, board);
        List<List<Integer>> movements = List.of(
                List.of(1,0),
                List.of(1,1),
                List.of(-1,0),
                List.of(1,-1),
                List.of(-1,1),
                List.of(-1,-1),
                List.of(0,1),
                List.of(0,-1)
        );

        if(color.name().equals("BLACK")){
            movements = this.whiteSideMovement(movements);
        }

        this.move = new Move(movements, board, List.of(Move.MoveFlag.POINT)){
            @Override
            public void update(List<Integer> currentPosition) {
                super.update(currentPosition);
                // Check if checkmate etc
            }
        };
    }
}
