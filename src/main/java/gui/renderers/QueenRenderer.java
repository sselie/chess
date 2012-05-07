package gui.renderers;

import chess.Piece;

public class QueenRenderer extends PieceRenderer {

    public static PieceRenderer queen() {
        return new QueenRenderer(null);
    }

    public QueenRenderer(Piece piece) {
        super( piece );
    }

    public String toString() {
        return "Q";
    }

}
