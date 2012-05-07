package gui;

import chess.*;
import gui.renderers.*;

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
        if (piece instanceof Bishop) {
            return new BishopRenderer((Bishop)piece);
        }
        if (piece instanceof Knight) {
            return new KnightRenderer((Knight)piece);
        }
        if (piece instanceof King) {
            return new KingRenderer((King)piece);
        }
        return null;
    }
}
