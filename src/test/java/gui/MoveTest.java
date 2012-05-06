package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static gui.GameFrame.TITLE;

public class MoveTest {

    GameFrame frame;
    GameDriver driver;

    @Before public void
    showGame() {
        frame = new GameFrame();
        frame.setVisible( true );
        driver = new GameDriver();
    }
    @After public void
    hideFrame() {
        frame.setVisible( false );
    }

    @Test public void
    frameTitle() {
        driver.hasTitle( TITLE );
    }
    
    @Test public void
    canDisplayAPawn() throws InterruptedException {
        frame.display( aPawn().white().on( "e2" ).build() );
        driver.hasPawnOn( "e2" );
    }
    
    @Test public void
    canMoveAPawn() {
        frame.display( aPawn().white().on("e2").build() );
        driver.cell( "e2" ).click();
        driver.cell( "e4" ).click();
        driver.hasPawnOn( "e4" );
        driver.hasNothingOn( "e2" );
    }

    @Test public void
    canDisplayAQueen() throws InterruptedException {
        frame.display( aQueen().black().on("d5").build() );
        driver.hasQueenOn( "d5" );
    }

    @Test public void
    canMoveAQueen() {
        frame.display( aQueen().black().on("d5").build() );
        driver.cell( "d5" ).click();
        driver.cell( "h5" ).click();
        driver.hasQueenOn( "h5" );
    }



}
