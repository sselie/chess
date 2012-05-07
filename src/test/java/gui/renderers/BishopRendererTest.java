package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.BishopBuilder.aBishop;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BishopRendererTest {

    JButton button = new JButton();

    @Test public void
    buttonVisitSetsTextToB() {
        button.setText( "some text" );
        new BishopRenderer( aBishop().build() ).visit( button );
        assertThat( button.getText(), equalTo( "B") );
    }

    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhiteBishop() {
        button.setForeground( PIECE_BLACK);
        new BishopRenderer( aBishop().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackBishop() {
        button.setForeground( PIECE_WHITE);
        new BishopRenderer( aBishop().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }
}
