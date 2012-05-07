package gui;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class QueenRendererTest {

    @Test
    public void
    displaysAsQ() {
        assertThat( new QueenRenderer(null).toString(), equalTo( "Q" ) );
    }

}
