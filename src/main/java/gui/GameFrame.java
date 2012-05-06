package gui;

import chess.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

        clearBoard();
        selection = null;
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
        pieces = new ArrayList<Piece>();
    }

    private Piece selection;
    protected void clicked(JButton source) {
        if (selection == null) {
            selection = getPieceByPosition( source.getName() );
        }
        else {
            take( selection );
            selection.setPosition( source.getName() );
            display( selection );
            selection = null;
        }
    }

    private void take(Piece piece) {
        getButtonNamed( piece.getPosition() ).setText( "" );
    }

    private List<Piece> pieces;
    public void display(Piece piece) {
        Renderer renderer = new RendererFactory().rendererOf( piece );
        getButtonNamed( piece.getPosition() ).setText( renderer.toString() );
        getButtonNamed( piece.getPosition() ).setForeground( renderer.getColor() );
        this.pieces.add( piece );
    }
    public void display(Piece... pieces) {
        for(Piece piece:pieces) {
            display( piece );
        }
    }

    protected Piece getPieceByPosition(String position) {
        for(Piece piece:pieces) {
            if (piece.getPosition().equalsIgnoreCase(position)) {
                return piece;
            }
        }
        return null;
    }

}
