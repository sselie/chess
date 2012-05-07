package gui;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RoockRendererTest {

    @Test public void
    isAPieceRenderer() {
        assertThat( new RoockRenderer(null), instanceOf( PieceRenderer.class ));
    }

    @Test
    public void
    displaysAsT() {
        assertThat( new RoockRenderer(null).toString(), equalTo( "R" ) );
    }

}
