package com.ectario.main;

import com.ectario.tools.*;
import com.ectario.objects.*;
import com.ectario.objects.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Board board = new Board();
    final static String initConfig = "BRA8 BNB8 BBC8 BQD8 BKE8 BBF8 BNG8 BRH8" + " " +
            "BPA7 BPB7 BPC7 BPD7 BPE7 BPF7 BPG7 BPH7" + " " +
            "WPA2 WPB2 WPC2 WPD2 WPE2 WPF2 WPG2 WPH2" + " " +
            "WRA1 WNB1 WBC1 WQD1 WKE1 WBF1 WNG1 WRH1";

    public static void main(String[] args) {
        String persoConfig = "BRA8 BNB8 BBC8 BQD8 BKE8 BBF8 BNG8 BRH8" + " " +
                             "BPB7 BPC7 BPD7 BPE7 BPF7 BPG7 BPH7" + " " +
                             "WPA2 WPB2 WPC2 WPD2 WPE2 WPF2 WPG2 WPH2" + " " +
                             "WRA1 WNB1 WBC1 WQD1 WKE1 WBF1 WNG1 WRH1";
        board.setConfig(initConfig);

        board.printBoard();

//        //Test to move one piece
//        tile.getPiece().getMove().update(tile.getPosition());
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("\nEnter move : ");
//        String INPUT = myObj.nextLine();  // Read user input
//        tile.getPiece().movePiece(tile.getPosition(), board.notationToPos(INPUT));

//        //Put .. where a testPiece can move
        Tile tile = null;
        try {

            tile = board.getTile(board.notationToPos("F2"));

        } catch (Board.TilePlacementException e) {
            e.printStackTrace();
        }
        assert tile != null;
        tile.getPiece().getMove().update(tile.getPosition());
        for(List<Integer> tmpPos : tile.getPiece().getMove().getPossibleTargets()){
            Piece tmpPiece = new XX_piece(board);
            Tile newTmpTile = new Tile.OccupiedTile(tmpPos, tmpPiece);
            try {
                board.setTile(newTmpTile);
            } catch (Board.TilePlacementException e) {
                e.printStackTrace();
            }
        }

//        // Play randomly
//        tile.getPiece().getMove().update(tile.getPosition());
//        tile.getPiece().movePiece(tile.getPosition(), tile.getPiece().getMove().getPossibleTargets().get(Tools.randrange(0,
//                tile.getPiece().getMove().getPossibleTargets().size())));

        board.printBoard();

    }
}
