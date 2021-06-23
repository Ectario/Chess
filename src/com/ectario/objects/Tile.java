package com.ectario.objects;


public abstract class Tile {

    protected int place;

    public Tile(int place){
        this.place = place;
    }

    public abstract boolean isEmpty();
    public abstract Piece getPiece();

    @Override
    public String toString() {
        // Return the place and the piece
        return super.toString();
    }

    public static class EmptyTile extends Tile {

        public EmptyTile(int place) {
            super(place);
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

        public OccupiedTile(int place) {
            super(place);
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }


}
