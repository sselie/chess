package gui;

import chess.Piece;
import gui.renderers.PieceRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {

    public static final String TITLE = "Chess";
    public static final Color CELL_WHITE = new Color(240, 217, 181);
    public static final Color CELL_BLACK = new Color(181, 136, 99);

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

        selection = null;
        pieces = new ArrayList<Piece>();
}

    private void createLine(int line) {
        Color color = line % 2 == 0 ? CELL_WHITE : CELL_BLACK;
        for (char column = 0; column < 8; column++) {
            this.create( letterOf( column ) + line, color );
            color = color == CELL_BLACK ? CELL_WHITE : CELL_BLACK;
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

    private Piece selection;
    protected void clicked(JButton source) {
        if (selection == null) {
            selection = getPieceByPosition( source.getName() );
        }
        else {
            getButtonNamed( selection.getPosition() ).setText( "" );
            Piece potentialEaten = getPieceByPosition( source.getName() );
            if (potentialEaten != null) {
                pieces.remove( potentialEaten );
            }
            selection.setPosition( source.getName() );
            display( selection );
            selection = null;
        }
    }

    private List<Piece> pieces;
    public void display(Piece piece) {
        PieceRenderer renderer = new RendererFactory().rendererOf( piece );
        renderer.visit( getButtonNamed( piece.getPosition() ) );
        if (!pieces.contains( piece )) {
            pieces.add( piece );
        }
    }
    public void display(Piece... given) {
        for(Piece piece:given) {
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

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getSelection() {
        return selection;
    }
}
