package com.ectario.objects;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private int width = 0;
    private int height = 0;
    private final ArrayList<ArrayList<Tile>> matrix = new ArrayList<>();

    public Board(int width, int height){
        this.width = width;
        this.height = height;

        for(int i = 0; i < height; i++){
            ArrayList<Tile> line = new ArrayList<>();
            for(int j = 0; j < width; j++){
                line.add(new Tile.EmptyTile(intPlaceToTuplePos( i*this.width + j)));
            }
            this.matrix.add(line);
        }
    }

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

    public Tile getTile(List<Integer> position) throws TilePlacementException {
        int x = position.get(0);
        int y = position.get(1);
        if(x < 0 || y < 0 || y > height-1 || x > width-1)
        {
            throw new TilePlacementException("Error in getTile in a board : the new position isn't on the board");
        }
        return matrix.get(x).get(y);
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
