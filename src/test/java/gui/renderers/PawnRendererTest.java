package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.PawnBuilder.aPawn;
import static gui.renderers.PawnRenderer.pawn;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PawnRendererTest {

    @Test public void
    displaysAsP() {
        assertThat( pawn().toString(), equalTo( "P" ) );
    }

    @Test public void
    buttonVisitSetsTextToP() {
        JButton button = new JButton( "some text" );
        new PawnRenderer( aPawn().build() ).visit( button );
        assertThat( button.getText(), equalTo( "P") );
    }
    
    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhitePawn() {
        JButton button = new JButton();
        button.setForeground( PIECE_BLACK);
        new PawnRenderer( aPawn().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackPawn() {
        JButton button = new JButton();
        button.setForeground( PIECE_WHITE);
        new PawnRenderer( aPawn().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }
    
}
