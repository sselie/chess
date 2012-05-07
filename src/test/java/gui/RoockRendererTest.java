package gui;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.awt.*;

import static builders.RockBuilder.aRock;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RoockRendererTest {

    @Test
    public void
    displaysAsT() {
        assertThat( new RoockRenderer(null).toString(), equalTo( "R" ) );
    }

    @Test public void
    whiteColorForAWhitePawn() {
        assertThat( new RoockRenderer( aRock().white().build() ).getColor(), Is.is( Color.white ) );
    }

    @Test public void
    blackColorForABlackPawn() {
        assertThat( new RoockRenderer( aRock().black().build() ).getColor(), Is.is( Color.black ) );
    }
}
