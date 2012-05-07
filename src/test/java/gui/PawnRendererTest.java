package gui;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PawnRendererTest {

    @Test public void
    displaysAsP() {
        assertThat( new PawnRenderer(null).toString(), equalTo( "P" ) );
    }
    
}
