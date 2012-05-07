package gui.renderers;

import chess.Piece;

public class PawnRenderer extends PieceRenderer {

    public static PieceRenderer pawn() {
        return new PawnRenderer(null);
    }

    public PawnRenderer(Piece piece) {
        super( piece );
    }

    public String toString() {
        return "P";
    }


}
