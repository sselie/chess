package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.KingBuilder.aKing;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class KingRendererTest {

    JButton button = new JButton();

    @Test public void
    buttonVisitSetsTextToK() {
        button.setText( "some text" );
        new KingRenderer( aKing().build() ).visit( button );
        assertThat( button.getText(), equalTo( "K") );
    }

    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhiteBishop() {
        button.setForeground( PIECE_BLACK);
        new KingRenderer( aKing().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackBishop() {
        button.setForeground( PIECE_WHITE);
        new KingRenderer( aKing().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }
}
