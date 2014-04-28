package builders;

import chess.Pawn;

public class PawnBuilder extends PieceBuilder<Pawn> {

    public static PawnBuilder aPawn() {
        return new PawnBuilder();
    }

    @Override
    protected Pawn getPiece()
    {
        return new Pawn();
    }
}
