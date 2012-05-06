package gui;

import chess.Pawn;
import chess.Queen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GameFrame.this.clicked( (JButton) actionEvent.getSource() );
            }
        } );
    }

    public JButton getButtonNamed(String name) {
        Component[] all = this.getContentPane().getComponents();
        for( Component component : all) {
            if (component.getName().equalsIgnoreCase(name)) {
                return (JButton) component;
            }
        }
        return null;
    }

    private void clearBoard() {
        Component[] all = this.getContentPane().getComponents();
        for( Component component : all) {
            ((JButton) component).setText( "" );
        }
    }

    private Pawn pawn;
    public void display(Pawn pawn) {
        getButtonNamed( pawn.getPosition() ).setText( new PawnRenderer(pawn).toString() );
        getButtonNamed( pawn.getPosition() ).setForeground( new PawnRenderer(pawn).getColor() );
        this.pawn = pawn;
    }

    protected void clicked(JButton source) {
        this.pawn.setPosition( source.getName() );
        this.clearBoard();
        this.display( pawn );
    }

    private Queen queen;
    public void display(Queen queen) {
        getButtonNamed( queen.getPosition() ).setText( new QueenRenderer(queen).toString() );
        getButtonNamed( queen.getPosition() ).setForeground( new QueenRenderer(queen).getColor() );
        this.queen = queen;
    }
}
