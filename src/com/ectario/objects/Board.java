package com.ectario.objects;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
                line.add(new Tile.EmptyTile(i+j));
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
                line.add(new Tile.EmptyTile(i+j));
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
                    System.out.print("|" + "_");
                }
            }
            System.out.print("|");

        }
    }

    public void clearBoard(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                this.matrix.get(i).set(j, new Tile.EmptyTile(i+j));
            }
        }
    }

    public List<Integer> intPlaceToTuplePos(int place){
        //TODO : Translate int to pos
        List<Integer> tuple = List.of(1,1);
        return tuple;
    }
}
