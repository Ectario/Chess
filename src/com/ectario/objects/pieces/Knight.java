package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class Knight extends Piece {
    public Knight(PieceType pieceType, Color color, Board board) {
        super(pieceType, color, board);
        this.move = new Move(List.of(List.of(2,3)), board) {
            @Override
            public void update(List<Integer> currentPosition) {
                super.update(currentPosition);
            }
        };
    }

    @Override
    public void movePiece(List<Integer> currentPosition, List<Integer> position){
        if(move.isPossible(currentPosition, position)){

        }
    }
}
