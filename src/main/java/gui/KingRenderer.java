package gui;

import chess.Piece;

public class KingRenderer extends PieceRenderer {

    public KingRenderer(Piece piece) {
        super(piece);
    }

    @Override
    public String toString() {
        return "K";
    }
}
