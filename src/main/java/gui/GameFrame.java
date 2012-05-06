package gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static final String TITLE = "Chess";

    public GameFrame() {
        this.setName( TITLE );
        this.setTitle( TITLE );
        this.setSize( 500, 500 );

        this.getContentPane().setLayout( new GridLayout( 8, 8 ) );

        this.createLine( 8 );
        this.createLine( 7 );
        this.createLine( 6 );
        this.createLine( 5 );
        this.createLine( 4 );
        this.createLine( 3 );
        this.createLine( 2 );
        this.createLine( 1 );
    }

    private void createLine(int number) {
        Color color = number % 2 == 0 ? Color.darkGray : Color.lightGray;
        for (char letter = 0; letter < 8; letter++) {
            this.create(
                    new Character( (char) (97 + letter) ).toString() + number,
                    color );
            color = color == Color.darkGray ? Color.lightGray : Color.darkGray;
        }
    }

    private void create(String name, Color color) {
        JButton button = new JButton();
        button.setName( name );
        button.setOpaque( true );
        button.setBackground( color );
        button.setBorderPainted( false );
        this.getContentPane().add( button );
    }
}
