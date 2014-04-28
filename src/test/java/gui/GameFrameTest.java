package gui;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import imhotep.Imhotep;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import chess.Game;
import chess.Pawn;
import chess.Queen;

@Imhotep(level="Unit")
public class GameFrameTest {

    GameFrame frame;
    Game game;

    @Before
    public void
    showGame() {
        game = new Game();
        frame = new GameFrame(game);
    }

    @Test public void
    gridLayout() {
        assertThat( frame.getContentPane().getLayout(), instanceOf( GridLayout.class ) );
    }

    @Test public void
    allComponentsMustBeOpaque() {
        final Component[] all = frame.getContentPane().getComponents();
        for( final Component component : all) {
            assertTrue( component.getName() + " should be opaque", component.isOpaque() );
        }
    }

    @Test public void
    allCellsMustHaveAnEmptyContentByDefault() {
        final Component[] all = frame.getContentPane().getComponents();
        for( final Component component : all) {
            assertThat( ((JButton) component).getText(), equalTo( "" ) );
        }
    }

    @Test public void
    allCellsMustHaveAnEmptyImageByDefault() {
        final Component[] all = frame.getContentPane().getComponents();
        for( final Component component : all) {
            assertThat( ((JButton) component).getIcon(), equalTo( null ) );
        }
    }

    @Test public void
    createTheALetterFromIntValue97() {
        assertThat( new Character( (char) 97 ).toString(), equalTo( "a" ));
    }

    @Test public void
    recordPiecesPosition() {
        final Queen queen = aQueen().white().on( "d1" ).build();
        final Pawn pawn = aPawn().white().on( "d2" ).build();
        frame.display( queen, pawn );
        assertThat( (Queen) game.getPieces().getPieceWithPosition( "d1" ), equalTo( queen ) );
        assertThat( (Pawn) game.getPieces().getPieceWithPosition( "d2" ), equalTo( pawn ) );
    }

    @Test public void
    delegatesMoveActionToMoveCommand() {
        final MoveCommand moveMoveCommand = mock( MoveCommand.class );
        frame.display( aQueen().black().on( "d5" ).build() );
        frame.clicked( frame.getButtonNamed( "d5" ) );
        frame.clicked( frame.getButtonNamed( "e5" ) );

        verify( moveMoveCommand ).move( "d5", "e5" );
    }

}
