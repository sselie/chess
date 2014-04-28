package chess;

import gui.MoveAndEat;
import gui.MoveCommand;

public class Game
{
    private final Pieces pieces;
    private Piece selection;
    private final MoveCommand moveCommand;

    public Game()
    {
        pieces = new Pieces();
        moveCommand = new MoveAndEat( pieces );
    }

    public Pieces getPieces() {
        return pieces;
    }

    public void select(final String position)
    {
        if (selection == null) {
            selection = pieces.getPieceWithPosition( position );
        }
        else {
            moveCommand.move( selection.getPosition(), position );
            selection = null;
        }
    }
}
