package gui;

import chess.Pawn;

import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class PawnRenderer {

    private Pawn pawn;

    public PawnRenderer(Pawn pawn) {
        this.pawn = pawn;
    }

    public String toString() {
        return "P";
    }

    public Color getColor() {
        return pawn.isWhite() ? white : black;
    }
}
