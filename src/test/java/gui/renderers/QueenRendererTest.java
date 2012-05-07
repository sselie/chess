package gui.renderers;

import org.junit.Test;

import javax.swing.*;

import static builders.QueenBuilder.aQueen;
import static gui.renderers.PieceRenderer.PIECE_BLACK;
import static gui.renderers.PieceRenderer.PIECE_WHITE;
import static gui.renderers.QueenRenderer.queen;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class QueenRendererTest {

    @Test public void
    displaysAsQ() {
        assertThat( queen().toString(), equalTo( "Q" ) );
    }

    @Test public void
    buttonVisitSetsTextToQ() {
        JButton button = new JButton( "some text" );
        new QueenRenderer( aQueen().build() ).visit( button );
        assertThat( button.getText(), equalTo( "Q") );
    }

    @Test public void
    buttonVisitSetsForegroundToWhiteForAWhiteQueen() {
        JButton button = new JButton();
        button.setForeground( PIECE_BLACK);
        new QueenRenderer( aQueen().white().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_WHITE ));
    }

    @Test public void
    buttonVisitSetsForegroundToBlackForABlackQueen() {
        JButton button = new JButton();
        button.setForeground( PIECE_WHITE);
        new QueenRenderer( aQueen().black().build() ).visit( button );
        assertThat( button.getForeground(), equalTo( PIECE_BLACK ));
    }

}
