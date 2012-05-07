package gui.renderers;

import chess.Piece;

import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public abstract class PieceRenderer {

    private Piece piece;

    public PieceRenderer(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return piece.isWhite() ? white : black;
    }

    public abstract String toString();
}
