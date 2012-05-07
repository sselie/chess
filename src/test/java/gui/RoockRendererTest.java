package gui;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RoockRendererTest {

    @Test
    public void
    displaysAsT() {
        assertThat( new RoockRenderer(null).toString(), equalTo( "R" ) );
    }

}
