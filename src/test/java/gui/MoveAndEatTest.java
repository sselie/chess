package gui;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;
import imhotep.Imhotep;

import org.junit.Before;
import org.junit.Test;

import chess.Game;
import chess.Pieces;
import chess.Queen;

@Imhotep(level="Domain")
public class MoveAndEatTest {

    GameFrame frame;
    Game game;
    MoveAndEat moveCommand;
    Pieces pieces;

    @Before public void
    movingAQueenOnAPawn() {
        game = new Game();
        frame = new GameFrame(game);
        frame.display( aQueen().black().on( "d5" ).build() );
        frame.display( aPawn().white().on( "e5" ).build() );
        frame.display( aPawn().white().on( "f5" ).build() );
        pieces = game.getPieces();

        game.select("d5");
        game.select("e5");
//        moveCommand = new MoveAndEat( pieces );
//        moveCommand.move( "d5", "e5" );
    }

    @Test public void
    movesTheQueen() {
        assertThat( pieces.getPieceWithPosition( "e5" ), instanceOf( Queen.class ) );
    }

    @Test public void
    eatsThePawn() {
        assertThat( game.getPieces().size(), equalTo( 2 ) );
    }

    @Test public void
    unlessThereIsNobodyOnTheTargetPosition() {
        game.select("e5");
        game.select("e3");
//        moveCommand.move( "e5", "e3" );

        assertThat( pieces.getPieceWithPosition( "e3" ), instanceOf( Queen.class ) );
        assertThat( pieces.size(), equalTo( 2 ) );
    }

    @Test public void
    updateInitialPositionDrawing() {
        assertThat( frame.getButtonNamed( "d5" ).getIcon(), equalTo( null ) );
    }

    @Test public void
    updateTargetPositionDrawing() {
        assertThat( frame.getButtonNamed( "e5" ).getIcon().toString(), containsString( "queen" ) );
    }
}
