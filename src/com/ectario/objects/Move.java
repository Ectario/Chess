package com.ectario.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Abstract Class used to manage if a move is allowed.
public class Move {

    private ArrayList<List<Integer>> possiblePositions = new ArrayList();
    private Board board;
    private List<List<Integer>> relativeTargetedPositions;

    // relativeTargetedPositions is relative to the Piece, example : The piece can move only in the right tile, then the only one targeted position is (1,0) -> 1 in x axe and 0 in y axe
    public Move(List<List<Integer>> relativeTargetedPositions, Board board) {
        this.board = board;
        this.relativeTargetedPositions = relativeTargetedPositions;
    }

    // Update the possible position of the move
    public void update(List<Integer> currentPos){
        possiblePositions.clear();
        // For each position in relativePosition we add the currentPos -> Can get the Absolut position of each targetedPositions
        List<List<Integer>> newTargetedPositions = relativeTargetedPositions.stream().map(elt -> addPosition(elt, currentPos)).collect(Collectors.toList());
        for(List<Integer> pos : newTargetedPositions){
            if(!(pos.get(0) > board.getWidth() || pos.get(0) < 0 || pos.get(1) > board.getHeight() || pos.get(1) < 0)) //Check if Positions targeted is on the board
            {
                possiblePositions.add(pos);
            }
        }

    }

    public ArrayList<List<Integer>> getPossibleTargets(){
        return possiblePositions;
    }

    // Check if move from currentPos to a new position is possible
    public boolean isPossible(List<Integer> currentPosition, List<Integer> position){
        update(currentPosition);
        for(List<Integer> pos : possiblePositions){
            if(pos.get(0) == position.get(0) && pos.get(1) == position.get(1)){
                return true;
            }
        }
        return false;
    }


    private List<Integer> addPosition(List<Integer> pos, List<Integer> pos2) {
        return List.of(pos.get(0) + pos2.get(0), pos.get(1) + pos2.get(1));
    }

    //TODO : Manage flagging
    public enum SpecialMoveFlag {
        LINE,
        DIAGONAL
    }
}
