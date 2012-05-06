package support;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.ComponentDriver;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

import static gui.GameFrame.TITLE;
import static org.hamcrest.CoreMatchers.equalTo;

public class GameDriver extends JFrameDriver {

    @SuppressWarnings("unchecked")
    public GameDriver() {
        super(new GesturePerformer(), new AWTEventQueueProber(), named( TITLE ), showingOnScreen());
        ((AWTEventQueueProber) prober()).setTimeout( 100 );
    }
    public JLabelDriver label(String name) {
        return new JLabelDriver(this, ComponentDriver.named( name ));
    }
    public JButtonDriver button(String name) {
        return new JButtonDriver(this, JButton.class, ComponentDriver.named( name ));
    }

    public void hasPawnOn(String cell) {
        button( cell ).hasText( equalTo("P" ) );
    }

    public JButtonDriver cell(String name) {
        return button( name );
    }
}
