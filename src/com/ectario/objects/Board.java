package com.ectario.objects;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board
{
    private int width = 0;
    private int height = 0;
    private final ArrayList<ArrayList<Tile>> matrix = new ArrayList<>();

    public Board(){
        this.width = 8;
        this.height = 8;

        for(int i = 0; i < height; i++){
            ArrayList<Tile> line = new ArrayList<>();
            for(int j = 0; j < width; j++){
                line.add(new Tile.EmptyTile( intPlaceToTuplePos( i*this.width + j )) );
            }
            this.matrix.add(line);
        }
    }

    public ArrayList<ArrayList<Tile>> getBoard(){
        return this.matrix;
    }

    public void printBoard(){
        for(int i = 0; i < this.height; i++){
            System.out.println();
            System.out.print(height-i + ". "); //Print the line number
            for(int j = 0; j < this.width; j++){
                if(this.matrix.get(i).get(j).getPiece() != null){
                    System.out.print("|" + this.matrix.get(i).get(j).getPiece().toStringAbbreviation());
                } else {
                    System.out.print("|" + "__");
                }
            }
            System.out.print("|");
        }

        System.out.println();
        System.out.println("    A  B  C  D  E  F  G  H");
    }

    public void clearBoard(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                matrix.get(i).set(j, new Tile.EmptyTile(intPlaceToTuplePos( i*this.width + j )));
            }
        }
    }

    public void setTile(Tile tile) throws TilePlacementException {
        List<Integer> position = tile.getPosition();
        if(position.get(0) > width || position.get(0) < 0 || position.get(1) > height || position.get(1) < 0)
        {
            throw new TilePlacementException("Error in changeTile in a board : the new position isn't on the board");
        }
        matrix.get(position.get(1)).set(position.get(0), tile);
    }

    // Translate notation to positions like B4 to (1,4)
    public List<Integer> notationToPos(String notation){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",0);
        map.put("b",1);
        map.put("c",2);
        map.put("d",3);
        map.put("e",4);
        map.put("f",5);
        map.put("g",6);
        map.put("h",7);
        notation = notation.toLowerCase();
        int x = map.get(String.valueOf(notation.charAt(0)));
        int y = height - notation.charAt(1) + 48; // + 48 because ascii '0' start at 48.
        return List.of(x,y);
    }

    public Tile getTile(List<Integer> position) throws TilePlacementException {
        int x = position.get(0);
        int y = position.get(1);
        if(x < 0 || y < 0 || y > height-1 || x > width-1)
        {
            throw new TilePlacementException("Error in getTile in a board : the new position isn't on the board");
        }
        return matrix.get(x).get(y);
    }

    // Manage configurations with a notation like WQB4 for White Queen in B4 to initialize a game
    public void setConfig(String configNotation){
        this.clearBoard();

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public static class TilePlacementException extends Exception {
        TilePlacementException(String str){
            super(str);
        }
    }

    private List<Integer> intPlaceToTuplePos(int place){
        int x = (place) % width;
        int y = (int) Math.floor((float) place/width);
        return List.of(x, y);
    }

}
