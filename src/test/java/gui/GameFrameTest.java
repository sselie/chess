package gui;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static builders.PawnBuilder.aPawn;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameFrameTest {

    GameFrame frame;

    @Before
    public void
    showGame() {
        frame = new GameFrame();
    }

    @Test public void
    gridLayout() {
        assertThat( frame.getContentPane().getLayout(), instanceOf( GridLayout.class ) );
    }
    
    @Test public void
    allComponentsMustBeOpaque() {
        Component[] all = frame.getContentPane().getComponents();
        for( Component component : all) {
            assertTrue( component.getName() + " should be opaque", component.isOpaque() );
        }
    }

    @Test public void
    allCellsMustHaveAnEmptyContent() {
        Component[] all = frame.getContentPane().getComponents();
        for( Component component : all) {
            assertThat( ((JButton) component).getText(), equalTo( "" ) );
        }
    }

    @Test public void
    createTheALetterFromIntValue65() {
        assertThat( new Character( (char) 97 ).toString(), equalTo( "a" ));
    }
    
    @Test public void
    aWhitePawnMustReallyBeWhite() {
        frame.display( aPawn().white().on( "a1" ).build() );
        assertThat( frame.getButtonNamed( "a1" ).getForeground(), is( Color.white ) );
    }
    
}
