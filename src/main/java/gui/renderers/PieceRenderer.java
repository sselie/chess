package gui.renderers;

import chess.Piece;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public abstract class PieceRenderer {

    public static final Color PIECE_WHITE = white;
    public static final Color PIECE_BLACK = black;
    private Piece piece;

    public PieceRenderer(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return piece.isWhite() ? PIECE_WHITE : PIECE_BLACK;
    }

    public void visit(JButton button) {
        button.setText( toString() );
        button.setForeground( getColor() );
    }

    public Piece getPiece() {
        return piece;
    }
}
