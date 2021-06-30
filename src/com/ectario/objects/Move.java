package com.ectario.objects;

import java.util.List;

public abstract class Move {

    private final List<List<Integer>> possiblePositions = List.of();
    private Board board;
    private List<List<Integer>> targetedPositions;

    public Move(List<List<Integer>> targetedPositions, Board board) {
        this.board = board;
        this.targetedPositions = targetedPositions;
    }

    public void update(List<Integer> currentPos){

        for(List<Integer> pos : targetedPositions){
            if(!(pos.get(0) > board.getWidth() || pos.get(0) < 0 || pos.get(1) > board.getHeight() || pos.get(1) < 0)) //Positions targeted is on the board
            {
                possiblePositions.add(pos);
            }
        }

    }

    //TODO : Manage flagging
    public enum SpecialMoveFlag {
        LINE,
        DIAGONAL
    }
}
