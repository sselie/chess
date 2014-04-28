package builders;

import chess.Roock;

public class RockBuilder extends PieceBuilder<Roock> {

    public static RockBuilder aRoock() {
        return new RockBuilder();
    }

    @Override
    protected Roock getPiece()
    {
        return new Roock();
    }

}
