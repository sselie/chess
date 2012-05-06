package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static gui.GameFrame.TITLE;
import static support.PawnBuilder.aPawn;

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
        frame.display( aPawn().white().on("e2").build() );
        driver.hasPawnOn("e2");
    }



}
