package builders;

import chess.Bishop;

public class BishopBuilder extends PieceBuilder<Bishop> {

    public static BishopBuilder aBishop() {
        return new BishopBuilder();
    }

    @Override
    protected Bishop getPiece()
    {
        return new Bishop();
    }
}
