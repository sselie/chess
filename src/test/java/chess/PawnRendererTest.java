package chess;

import gui.PawnRenderer;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PawnRendererTest {

    @Test public void
    displaysAsP() {
        assertThat( new PawnRenderer().toString(), equalTo( "P" ) );
    }
}
