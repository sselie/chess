package gui;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class KnightRendererTest {

    @Test
    public void
    displaysAsK() {
        assertThat( new KnightRenderer(null).toString(), equalTo( "K" ) );
    }
}
