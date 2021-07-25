package com.ectario.main;

import com.ectario.tools.*;
import com.ectario.objects.*;
import com.ectario.objects.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Board board = new Board();

    public static void main(String[] args) {
        String initConfig = "WpB2 bbC5 WRc8";
        board.setConfig(initConfig);

        board.printBoard();

//        //Test to move one piece
//        tile.getPiece().getMove().update(tile.getPosition());
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("\nEnter move : ");
//        String INPUT = myObj.nextLine();  // Read user input
//        tile.getPiece().movePiece(tile.getPosition(), board.notationToPos(INPUT));

//        //Put WK where a testPiece can move
//        tile.getPiece().getMove().update(tile.getPosition());
//        for(List<Integer> tmpPos : tile.getPiece().getMove().getPossibleTargets()){
//            Piece tmpPiece = new King(Color.WHITE, board);
//            Tile newTmpTile = new Tile.OccupiedTile(tmpPos, tmpPiece);
//            try {
//                board.setTile(newTmpTile);
//            } catch (Board.TilePlacementException e) {
//                e.printStackTrace();
//            }
//        }
//        board.printBoard();

//        // Play randomly
//        tile.getPiece().getMove().update(tile.getPosition());
//        tile.getPiece().movePiece(tile.getPosition(), tile.getPiece().getMove().getPossibleTargets().get(Tools.randrange(0,
//                tile.getPiece().getMove().getPossibleTargets().size())));

        board.printBoard();

    }
}
