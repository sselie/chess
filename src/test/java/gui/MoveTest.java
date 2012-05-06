package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static gui.GameFrame.TITLE;

public class MoveTest {

    GameFrame board;
    GameDriver driver;

    @Before public void
    showGame() {
        board = new GameFrame();
        board.setVisible( true );
        driver = new GameDriver();
    }
    @After public void
    hideFrame() {
        board.setVisible( false );
    }

    @Test public void
    frameTitle() {
        driver.hasTitle( TITLE );
    }
    
    @Test public void
    canDisplayAPawn() throws InterruptedException {
        board.display( aPawn().white().on( "e2" ).build() );
        driver.hasPawnOn( "e2" );
    }
    
    @Test public void
    canMoveAPawn() {
        board.display( aPawn().white().on( "e2" ).build() );
        driver.cell( "e2" ).click();
        driver.cell( "e4" ).click();
        driver.hasPawnOn( "e4" );
        driver.hasNothingOn( "e2" );
    }

    @Test public void
    canDisplayAQueen() throws InterruptedException {
        board.display( aQueen().black().on( "d5" ).build() );
        driver.hasQueenOn( "d5" );
    }

    @Test public void
    canMoveAQueen() {
        board.display( aQueen().black().on( "d5" ).build() );
        driver.cell( "d5" ).click();
        driver.cell( "h5" ).click();
        driver.hasQueenOn( "h5" );
    }

    @Test public void
    canMoveSeveralPieces() throws InterruptedException {
        board.display( aQueen().white().on( "d1" ).build(),
                aPawn().white().on( "d2" ).build() );

        driver.cell( "d1" ).click();
        driver.cell( "g4" ).click();
        driver.hasQueenOn( "g4" );

        driver.cell( "d2" ).click();
        driver.cell( "d3" ).click();
        driver.hasPawnOn( "d3" );

    }


}
