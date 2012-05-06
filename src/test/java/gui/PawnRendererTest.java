package gui;

import gui.PawnRenderer;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.awt.*;

import static builders.PawnBuilder.aPawn;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PawnRendererTest {

    @Test public void
    displaysAsP() {
        assertThat( new PawnRenderer(null).toString(), equalTo( "P" ) );
    }
    
    @Test public void
    whiteColorForAWhitePawn() {
        assertThat( new PawnRenderer( aPawn().white().build() ).getColor(), Is.is( Color.white ) );
    }

    @Test public void
    blackColorForABlackPawn() {
        assertThat( new PawnRenderer( aPawn().black().build() ).getColor(), Is.is( Color.black ) );
    }
}
