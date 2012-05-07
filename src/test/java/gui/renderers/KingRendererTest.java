package gui.renderers;

import gui.renderers.KingRenderer;
import gui.renderers.PieceRenderer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class KingRendererTest {

    @Test public void
    isAPieceRenderer() {
        assertThat( new KingRenderer(null), instanceOf( PieceRenderer.class ));
    }
    
    @Test
    public void
    displaysAsK() {
        assertThat( new KingRenderer(null).toString(), equalTo( "K" ) );
    }
}
