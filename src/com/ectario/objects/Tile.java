package com.ectario.objects;


public abstract class Tile {

    protected int place; //64 different place (0 to 63), 16 first are the white side
    protected Piece piece = null;


    public Tile(int pPlace){
        this.place = pPlace;
    }

    public abstract boolean isEmpty();
    public abstract Piece getPiece();

    @Override
    public String toString() {
        // Return the place and the piece
        return super.toString();
    }

    public static class EmptyTile extends Tile {

        public EmptyTile(int pPlace) {
            super(pPlace);
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

        public OccupiedTile(int pPlace, Piece pPiece) {
            super(pPlace);
            this.piece = pPiece;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return this.piece;
        }
    }


}
