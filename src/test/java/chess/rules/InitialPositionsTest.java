package chess.rules;

import gui.GameFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static chess.rules.InitialPositions.initialPositions;
import static support.GameDriver.on;
import static support.GameDriver.rook;

public class InitialPositionsTest {

    GameFrame game;
    GameDriver board;

    @Before
    public void
    showGame() {
        game = new GameFrame();
        game.setVisible( true );
        board = new GameDriver();
        game.display( initialPositions() );
    }
    @After
    public void
    hideFrame() {
        game.setVisible( false );
    }

    @Test public void
    displaysRooks() {
        board.hasWhite( rook(), on( "a1" ) );
        board.hasWhite( rook(), on( "h1" ) );
        board.hasBlack( rook(), on( "a8" ) );
        board.hasBlack( rook(), on( "h8" ) );
    }

}
