package com.ectario.objects;

import java.util.List;

//Abstract Class used to manage if a move is allowed.
public abstract class Move {

    private final List<List<Integer>> possiblePositions = List.of();
    private Board board;
    private List<List<Integer>> targetedPositions;

    // TargetedPositions is relative to the Piece, example : The piece can move only in the right, then the only one targeted position is (1,0) -> 1 in x axe and 0 in y axe
    public Move(List<List<Integer>> targetedPositions, Board board) {
        this.board = board;
        this.targetedPositions = targetedPositions;
    }

    // Update the possible position of the move
    public void update(List<Integer> currentPos){
        possiblePositions.clear();
        for(List<Integer> pos : targetedPositions){
            if(!(pos.get(0) > board.getWidth() || pos.get(0) < 0 || pos.get(1) > board.getHeight() || pos.get(1) < 0)) //Check if Positions targeted is on the board
            {
                possiblePositions.add(pos);
            }
        }

    }

    public boolean isPossible(List<Integer> currentPosition, List<Integer> position){
        update(currentPosition);
        for(List<Integer> pos : possiblePositions){
            if(pos == position){
                return true;
            }
        }
        return false;
    }

    //TODO : Manage flagging
    public enum SpecialMoveFlag {
        LINE,
        DIAGONAL
    }
}
