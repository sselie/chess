package gui;

import gui.renderers.PieceRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import chess.Game;
import chess.Piece;
import chess.Pieces;

public class GameFrame extends JFrame {

    public static final String TITLE = "Chess";
    public static final Color CELL_WHITE = new Color(240, 217, 181);
    public static final Color CELL_BLACK = new Color(181, 136, 99);
    private MoveCommand moveCommand;

    public GameFrame(final Game game) {
        this.setName( TITLE );
        this.setTitle( TITLE );
        this.setSize( 500, 500 );
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        pieces = new Pieces();
        moveCommand = new MoveAndEat( this, pieces );
    }

    private void createLine(final int line) {
        Color color = line % 2 == 0 ? CELL_WHITE : CELL_BLACK;
        for (char column = 0; column < 8; column++) {
            this.create( letterOf( column ) + line, color );
            color = color == CELL_BLACK ? CELL_WHITE : CELL_BLACK;
        }
    }

    private String letterOf(final char column) {
        return new Character( (char) (97 + column) ).toString();
    }

    private void create(final String name, final Color color) {
        final JButton button = new JButton();
        button.setName( name );
        button.setOpaque( true );
        button.setBackground( color );
        button.setBorderPainted( false );
        this.getContentPane().add( button );

        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                GameFrame.this.clicked( (JButton) actionEvent.getSource() );
            }
        } );
    }

    public JButton getButtonNamed(final String name) {
        final Component[] all = this.getContentPane().getComponents();
        for( final Component component : all) {
            if (component.getName().equalsIgnoreCase(name)) {
                return (JButton) component;
            }
        }
        return null;
    }

    private Piece selection;
    protected void clicked(final JButton source) {
        if (selection == null) {
            selection = pieces.getPieceWithPosition( source.getName() );
        }
        else {
            moveCommand.move( selection.getPosition(), source.getName() );
            selection = null;
        }
    }

    private final Pieces pieces;
    public Pieces getPieces() {
        return pieces;
    }

    public void display(final Piece piece) {
        final PieceRenderer renderer = new RendererFactory().rendererOf( piece );
        renderer.visit( getButtonNamed( piece.getPosition() ) );
        if (!pieces.contains( piece )) {
            pieces.add( piece );
        }
    }
    public void display(final Piece... given) {
        for(final Piece piece:given) {
            display( piece );
        }
    }

    public void setMoveCommand(final MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    public void clearPosition(final String initialPosition) {
        getButtonNamed( initialPosition ).setIcon( null );
    }
}
