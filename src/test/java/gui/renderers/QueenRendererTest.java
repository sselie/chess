package gui.renderers;

import gui.renderers.PieceRenderer;
import gui.renderers.QueenRenderer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class QueenRendererTest {

    @Test public void
    isAPieceRenderer() {
        assertThat( new QueenRenderer(null), instanceOf( PieceRenderer.class ));
    }

    @Test
    public void
    displaysAsQ() {
        assertThat( new QueenRenderer(null).toString(), equalTo( "Q" ) );
    }

}
