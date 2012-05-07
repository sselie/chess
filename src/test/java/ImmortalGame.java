import gui.GameFrame;
import org.junit.Ignore;
import org.junit.Test;
import support.GameDriver;

import static chess.rules.InitialPositions.initialPositions;

public class ImmortalGame {

    GameFrame game;
    GameDriver board;

    @Ignore
    @Test public void
    playImmortalGame() throws InterruptedException {
        while(true) {
            game = new GameFrame();
            game.setVisible( true );
            board = new GameDriver();
            game.display( initialPositions() );

            play( "e2", "e4" ); play( "e7", "e5" );
            play( "f2", "f4" ); play( "e5", "f4" );
            play( "f1", "c4" ); play( "d8", "h4" );
            play( "e1", "f1" ); play( "b7", "b5" );

            Thread.sleep( 3000 );
            game.setVisible( false );
        }
    }

    private void play(String origin, String destination) {
        board.cell( origin ).click();
        board.cell( destination ).click();
    }

}
