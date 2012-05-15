package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.RockBuilder.aRoock;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RoockRendererTest {

    JButton button = new JButton();

    @Test public void
    buttonVisitSetsTextToR() {
        button.setText( "some text" );
        new RoockRenderer( aRoock().build() ).visit( button );
        assertThat( button.getText(), equalTo( "R") );
    }

    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhiteRook() {
        button.setForeground( PIECE_BLACK);
        new RoockRenderer( aRoock().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackRook() {
        button.setForeground( PIECE_WHITE);
        new RoockRenderer( aRoock().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }

}
