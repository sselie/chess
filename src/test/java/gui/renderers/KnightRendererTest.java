package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.KnightBuilder.aKnight;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class KnightRendererTest {

    JButton button = new JButton();

    @Test public void
    buttonVisitSetsTextToN() {
        button.setText( "some text" );
        new KnightRenderer( aKnight().build() ).visit( button );
        assertThat( button.getText(), equalTo( "N") );
    }

    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhiteKnight() {
        button.setForeground( PIECE_BLACK);
        new KnightRenderer( aKnight().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackKnight() {
        button.setForeground( PIECE_WHITE);
        new KnightRenderer( aKnight().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }
}
