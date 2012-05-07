package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EatTest {

    GameFrame game;
    GameDriver board;

    @Before
    public void
    showGame() {
        game = new GameFrame();
        game.setVisible( true );
        board = new GameDriver();
    }
    @After
    public void
    hideFrame() {
        game.setVisible( false );
    }

    @Test public void
    canEat() throws InterruptedException {
        game.display( aQueen().white().on( "d1" ).build(),
                aPawn().white().on( "d2" ).build() );

        board.cell( "d1" ).click();
        board.cell( "d2" ).click();

        Thread.sleep(10);

        assertThat( game.getPieces().size(), equalTo( 1 ) );

    }
}
