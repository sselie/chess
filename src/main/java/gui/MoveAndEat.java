package gui;

import chess.Piece;
import chess.Pieces;

public class MoveAndEat implements MoveCommand {

    private final Pieces pieces;

    public MoveAndEat(final Pieces pieces) {
        this.pieces = pieces;
    }

    @Override
    public void move(final String initialPosition, final String targetPosition) {
        final Piece piece = pieces.getPieceWithPosition( initialPosition );
        final Piece eaten = pieces.getPieceWithPosition( targetPosition );
        pieces.remove( eaten );
        piece.setPosition( targetPosition );
    }
}
