package com.ectario.objects.pieces;

import com.ectario.objects.*;

import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, Board board) {
        super(PieceType.KNIGHT, color, board);
        this.move = new Move(List.of(List.of(1,3)), board) {
            @Override
            public void update(List<Integer> currentPosition) {
                super.update(currentPosition);
            }
        };
    }

    @Override
    public void movePiece(List<Integer> currentPosition, List<Integer> targetedPosition){
        if(move.isPossible(currentPosition, targetedPosition)){
            int currentPlace = board.tuplePosToIntPlace(currentPosition);
            int targetedPlace = board.tuplePosToIntPlace(targetedPosition);
            // The old tile become an Empty Tile and the target become an Occupied Tile
            Tile oldTile = new Tile.EmptyTile(currentPlace);
            Tile targetedTile = new Tile.OccupiedTile(targetedPlace, this);
            try {
                board.setTile(oldTile);
                board.setTile(targetedTile);
            } catch (Board.TilePlacementException e) {
                e.printStackTrace();
            }
        }
    }
}
