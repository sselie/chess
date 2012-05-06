package chess;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PawnTest {

    @Test public void
    displaysAsP() {
        assertThat( new Pawn().toString(), equalTo( "P" ) );
    }
}
