package builders;

import chess.Queen;

public class QueenBuilder extends PieceBuilder<Queen> {

    public static QueenBuilder aQueen() {
        return new QueenBuilder();
    }

    @Override
    protected Queen getPiece()
    {
        return new Queen();
    }
}
