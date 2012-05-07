package gui;

import chess.Pawn;
import chess.Piece;
import chess.Queen;

public class RendererFactory {

    public Renderer rendererOf(Piece piece) {
        if (piece instanceof Queen) {
            return new QueenRenderer((Queen) piece);
        }
        if (piece instanceof Pawn) {
            return new PawnRenderer((Pawn)piece);
        }
        return null;
    }
    
    public static Renderer queen() {
        return new QueenRenderer(null);
    }

    public static Renderer pawn() {
        return new PawnRenderer(null);
    }
}
