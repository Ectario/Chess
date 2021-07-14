package com.ectario.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Class used to manage if a move is allowed.
public class Move {

    private ArrayList<List<Integer>> possiblePositions = new ArrayList();
    private Board board;
    private List<List<Integer>> relativeTargetedPositions;
    private List<MoveFlag> flags;

    // relativeTargetedPositions is relative to the Piece,
    // example : The piece can move only in the right tile, then the only one targeted position is (1,0) -> 1 in x axe and 0 in y axe
    // If the flags doesn't contains POINT flag -> relativeTargetedPositions must be Empty initialize ArrayList
    public Move(List<List<Integer>> relativeTargetedPositions, Board board, List<MoveFlag> flags) {
        this.board = board;
        this.flags = flags;
        this.relativeTargetedPositions = relativeTargetedPositions;
    }

    // Update the possible position of the move
    public void update(List<Integer> currentPos){
        possiblePositions.clear();

        // If the piece Move has flag POINT then add the possiblePositions
        if(flags.contains(MoveFlag.POINT)) {
            // For each position in relativePosition we add the currentPos -> Can get the Absolut position of each targetedPositions
            List<List<Integer>> newTargetedPositions = relativeTargetedPositions.stream().map(elt -> addPosition(elt, currentPos)).collect(Collectors.toList());
            for (List<Integer> pos : newTargetedPositions) {
                if (!(pos.get(0) > board.getWidth() || pos.get(0) < 0 || pos.get(1) > board.getHeight() || pos.get(1) < 0)) //Check if Positions targeted is on the board
                {
                    possiblePositions.add(pos);
                }
            }
        }

        // If the piece Move has LINE then add the possiblePositions
        if(flags.contains(MoveFlag.LINE)) {
            List<Integer> direction = List.of(1, -1); // For X axe : 1 is the right and -1 the left
                                                      // For Y axe : 1 is for the top and -1 the bottom

            ArrayList<Integer> tmpPos;
            for (int i = 0; i < 2; i++) { // For get(0) : X axe, and get(1) : Y axe
                for (int dir : direction) {
                    tmpPos = new ArrayList(currentPos);
                    // Checking 1 direction until piece or border of board
                    while (true) {
                        tmpPos = new ArrayList(tmpPos); // Create the new tmpPos to avoid a pointer problem (until the next initialisation the pointer stay the same)
                        tmpPos.set(i, tmpPos.get(i) + dir);
                        try {
                            Tile tmpTile = board.getTile(tmpPos);
                            Piece pieceAlreadyThere = tmpTile.getPiece();
                            if (pieceAlreadyThere == null && tmpTile.isEmpty()) {
                                possiblePositions.add(tmpPos);
                            } else {
                                break; // Stopping this direction if a piece is already there
                            }
                        } catch (Board.TilePlacementException e) {
                            break; // Stopping this direction if the tmpPos isn't on the board
                        }
                    }
                }
            }
        }

        // If the piece Move has DIAGO then add the possiblePositions
        if(flags.contains(MoveFlag.DIAGO)) {
            List<Integer> direction = List.of(1, -1); // diagonale is like (x,x) (-x,-x) (-x,x) and (x,-x) where x is a variable

            ArrayList<Integer> tmpPos;
            for (int dirX : direction) {
                for (int dirY : direction) {
                    tmpPos = new ArrayList(currentPos);
                    // Checking 1 direction until piece or border of board
                    while (true) {
                        tmpPos = new ArrayList(tmpPos); // Create the new tmpPos to avoid a pointer problem (until the next initialisation the pointer stay the same)
                        tmpPos.set(1, tmpPos.get(1) + dirY);
                        tmpPos.set(0, tmpPos.get(0) + dirX);
                        try {
                            Tile tmpTile = board.getTile(tmpPos);
                            Piece pieceAlreadyThere = tmpTile.getPiece();
                            if (pieceAlreadyThere == null && tmpTile.isEmpty()) {
                                possiblePositions.add(tmpPos);
                            } else {
                                break; // Stopping this diagonal if a piece is already there
                            }
                        } catch (Board.TilePlacementException e) {
                            break; // Stopping this diagonal if the tmpPos isn't on the board
                        }
                    }
                }
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

    // POINT : If the piece can move in precise tile (like the knight)
    // LINE  : If the piece can move horizontally or vertically
    // DIAGO : If the piece can move in the diagonals
    public enum MoveFlag {
        LINE,
        DIAGO, // For diagonal
        POINT
    }
}
