package chess;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import gui.GameFrame;
import imhotep.Imhotep;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import support.GameDriver;

@Imhotep(level="UI")
public class CaptureTest {

    GameFrame game;
    GameDriver board;

    @Before
    public void
    showGame() {
        game = new GameFrame(null);
        game.setVisible( true );
        board = new GameDriver();
    }
    @After
    public void
    hideFrame() {
        game.setVisible( false );
    }

    @Test public void
    canCapture() throws InterruptedException {
        game.display( aQueen().white().on( "d1" ).build(),
                aPawn().black().on( "d7" ).build() );

        board.cell( "d1" ).click();
        board.cell( "d7" ).click();

        Thread.sleep(10);

        assertThat( game.getPieces().size(), equalTo( 1 ) );

    }
}
