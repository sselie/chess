package builders;

import chess.Knight;

public class KnightBuilder extends PieceBuilder<Knight> {

    public static KnightBuilder aKnight() {
        return new KnightBuilder();
    }

    @Override
    protected Knight getPiece()
    {
        return new Knight();
    }
}
