package gui;

import chess.Pawn;
import chess.Piece;
import chess.Queen;
import chess.Roock;

public class RendererFactory {

    public PieceRenderer rendererOf(Piece piece) {
        if (piece instanceof Queen) {
            return new QueenRenderer((Queen) piece);
        }
        if (piece instanceof Pawn) {
            return new PawnRenderer((Pawn)piece);
        }
        if (piece instanceof Roock) {
            return new RoockRenderer((Roock)piece);
        }
        return null;
    }
    
    public static PieceRenderer queen() {
        return new QueenRenderer(null);
    }

    public static PieceRenderer pawn() {
        return new PawnRenderer(null);
    }
}
