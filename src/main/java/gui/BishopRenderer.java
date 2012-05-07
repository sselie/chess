package gui;

import chess.Piece;

public class BishopRenderer extends PieceRenderer {

    public BishopRenderer(Piece piece) {
        super(piece);
    }

    public String toString() {
        return "B";
    }
}
