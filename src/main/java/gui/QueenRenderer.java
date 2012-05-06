package gui;

import chess.Queen;

import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class QueenRenderer {

    private Queen queen;

    public QueenRenderer(Queen queen) {
        this.queen = queen;
    }

    public Color getColor() {
        return queen.isWhite() ? white : black;
    }
    
    public String toString() {
        return "Q";
    }
}
