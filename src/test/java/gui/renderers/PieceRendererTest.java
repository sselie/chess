package gui.renderers;

import chess.Piece;
import gui.renderers.PieceRenderer;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertThat;

public class PieceRendererTest {

    @Test
    public void
    whiteColorForAWhitePiece() {
        Piece piece = new Piece(){
            public boolean isWhite() { return true; }
        };
        PieceRenderer renderer = new PieceRenderer(piece) {
            public String toString() {
                return null;
            }
        };
        assertThat( renderer.getColor(), Is.is( Color.white ) );
    }

    @Test
    public void
    blackColorForABlackPiece() {
        Piece piece = new Piece(){
            public boolean isWhite() { return false; }
        };
        PieceRenderer renderer = new PieceRenderer(piece) {
            public String toString() {
                return null;
            }
        };
        assertThat( renderer.getColor(), Is.is( Color.black ) );
    }

}
