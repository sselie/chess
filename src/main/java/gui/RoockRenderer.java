package gui;

import chess.Piece;

public class RoockRenderer extends PieceRenderer {

    public RoockRenderer(Piece piece) {
        super( piece );
    }

    public String toString() {
        return "R";
    }
}
