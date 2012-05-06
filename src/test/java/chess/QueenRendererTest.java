package chess;

import gui.QueenRenderer;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.awt.*;

import static builders.QueenBuilder.aQueen;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class QueenRendererTest {

    @Test
    public void
    displaysAsQ() {
        assertThat( new QueenRenderer(null).toString(), equalTo( "Q" ) );
    }

    @Test public void
    whiteColorForAWhitePawn() {
        assertThat( new QueenRenderer( aQueen().white().build() ).getColor(), Is.is( Color.white ) );
    }

    @Test public void
    blackColorForABlackPawn() {
        assertThat( new QueenRenderer( aQueen().black().build() ).getColor(), Is.is( Color.black ) );
    }
}
