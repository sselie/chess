package gui;

import org.junit.Test;
import support.GameDriver;

import static gui.GameFrame.TITLE;

public class GameFrameTest {

    @Test public void
    frameTitle() {
        GameFrame game = new GameFrame();
        game.setVisible( true );
        GameDriver driver = new GameDriver();
        driver.hasTitle( TITLE );
    }

}
