package gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.GameDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static gui.GameFrame.TITLE;
import static gui.RendererFactory.pawn;
import static gui.RendererFactory.queen;
import static support.GameDriver.on;

public class MoveTest {

    GameFrame game;
    GameDriver board;

    @Before public void
    showGame() {
        game = new GameFrame();
        game.setVisible( true );
        board = new GameDriver();
    }
    @After public void
    hideFrame() {
        game.setVisible( false );
    }

    @Test public void
    frameTitle() {
        board.hasTitle( TITLE );
    }
    
    @Test public void
    canDisplayAPawn() throws InterruptedException {
        game.display( aPawn().white().on( "e2" ).build() );
        board.has( pawn(), on( "e2" ) );
    }
    
    @Test public void
    canMoveAPawn() {
        game.display( aPawn().white().on( "e2" ).build() );
        board.cell( "e2" ).click();
        board.cell( "e4" ).click();
        board.has( pawn(), on( "e4" ) );
        board.hasNothingOn( "e2" );
    }

    @Test public void
    canDisplayAQueen() throws InterruptedException {
        game.display( aQueen().black().on( "d5" ).build() );
        board.has( queen(), on( "d5" ) );
    }

    @Test public void
    canMoveAQueen() {
        game.display( aQueen().black().on( "d5" ).build() );
        board.cell( "d5" ).click();
        board.cell( "h5" ).click();
        board.has( queen(), on( "h5" ) );
    }

    @Test public void
    canMoveSeveralPieces() throws InterruptedException {
        game.display( aQueen().white().on( "d1" ).build(),
                aPawn().white().on( "d2" ).build() );

        board.cell( "d1" ).click();
        board.cell( "g4" ).click();
        board.has( queen(), on( "g4" ) );

        board.cell( "d2" ).click();
        board.cell( "d3" ).click();
        board.has( pawn(), on( "d3" ) );
    }
    


}
