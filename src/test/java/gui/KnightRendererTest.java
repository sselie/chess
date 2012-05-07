package gui;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class KnightRendererTest {

    @Test public void
    isAPieceRenderer() {
        assertThat( new KnightRenderer(null), instanceOf( PieceRenderer.class ));
    }

    @Test
    public void
    displaysAsN() {
        assertThat( new KnightRenderer(null).toString(), equalTo( "N" ) );
    }
}
