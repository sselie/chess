package gui;

import chess.Pawn;

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

    private void createLine(int line) {
        Color color = line % 2 == 0 ? Color.lightGray : Color.darkGray;
        for (char column = 0; column < 8; column++) {
            this.create( letterOf( column ) + line, color );
            color = color == Color.darkGray ? Color.lightGray : Color.darkGray;
        }
    }

    private String letterOf(char column) {
        return new Character( (char) (97 + column) ).toString();
    }

    private void create(String name, Color color) {
        JButton button = new JButton();
        button.setName( name );
        button.setOpaque( true );
        button.setBackground( color );
        button.setBorderPainted( false );
        this.getContentPane().add( button );
    }

    public void display(Pawn pawn) {
        cell( pawn.getCell() ).setText( "P" );
    }

    private JButton cell(String name) {
        Component[] all = this.getContentPane().getComponents();
        for( Component component : all) {
            if (component.getName().equalsIgnoreCase(name)) {
                return (JButton) component;
            }
        }
        return null;
    }
}
