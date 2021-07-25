package com.ectario.objects.pieces;

import com.ectario.objects.Board;
import com.ectario.objects.Color;
import com.ectario.objects.Piece;
import com.ectario.objects.PieceType;

// Represented by ".." in abbreviation -> used to see the possible moves for 1 piece
public class XX_piece extends Piece {
    public XX_piece(Board board) {
        super(PieceType.XX, Color.BLACK, board);
    }

    @Override
    public String toStringAbbreviation(){
        return "..";
    }
}
