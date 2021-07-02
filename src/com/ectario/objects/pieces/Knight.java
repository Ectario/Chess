package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class Knight extends Piece {

    public Knight(Color color, Board board){
        super(PieceType.KNIGHT, color, board);
        List<List<Integer>> movement = List.of(
                List.of(2,1),
                List.of(-2,1),
                List.of(2,-1),
                List.of(1,2),
                List.of(-1,2),
                List.of(-1,-2),
                List.of(-2,-1),
                List.of(1,-2)
        );
        this.move = new Move(movement, board);
    }
}
