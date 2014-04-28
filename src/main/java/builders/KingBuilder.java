package builders;

import chess.King;

public class KingBuilder extends PieceBuilder<King> {

    public static KingBuilder aKing() {
        return new KingBuilder();
    }


    @Override
    protected King getPiece()
    {
        return new King();
    }
}
