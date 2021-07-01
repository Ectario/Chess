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
                line.add(new Tile.EmptyTile((i*this.width) +j));
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
                line.add(new Tile.EmptyTile((i*this.width) +j));
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
    }

    public void clearBoard(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                matrix.get(i).set(j, new Tile.EmptyTile((i*this.width) +j));
            }
        }
    }

    public void setTile(Tile tile, List<Integer> position) throws TilePlacementException {
        if(position.get(0) > width || position.get(0) < 0 || position.get(1) > height || position.get(1) < 0)
        {
            throw new TilePlacementException("Error in changeTile in a board : the new position isn't on the board");
        }
        matrix.get(position.get(1)).set(position.get(0), tile);
    }

    public List<Integer> intPlaceToTuplePos(int place){
        int x = (place+1) % width;
        int y = (int) Math.floor((float) place/width);
        return List.of(x, y);
    }

    public int tuplePosToIntPlace(@NotNull List<Integer> position){
        return position.get(0) + (position.get(1) * width);
    }

    public Tile getTile(int place){
        int x = intPlaceToTuplePos(place).get(0);
        int y = intPlaceToTuplePos(place).get(1);
        return matrix.get(x).get(y);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private static class TilePlacementException extends Exception {
        TilePlacementException(String str){
            super(str);
        }
    }

}
