package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

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
    

}
