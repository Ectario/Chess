package com.ectario.objects;


import java.util.List;

public abstract class Tile {

    protected List<Integer> position; // Position on the board (x, y)
    protected Piece piece = null;


    public Tile(List<Integer> position){
        this.position = position;
    }

    public abstract boolean isEmpty();
    public abstract Piece getPiece();

    public List<Integer> getPosition(){
        return position;
    }

    @Override
    public String toString() {
        // Return the place and the piece
        return super.toString();
    }

    public static class EmptyTile extends Tile {

        public EmptyTile(List<Integer> position) {
            super(position);
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    public static class OccupiedTile extends Tile {

        public OccupiedTile(List<Integer> position, Piece piece) {
            super(position);
            this.piece = piece;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return this.piece;
        }

        public void setPiece(Piece piece){
            this.piece = piece;
        }
    }


}
