package support;

import chess.Pawn;

public class PawnBuilder {

    private String cell;

    public static PawnBuilder aPawn() {
        return new PawnBuilder();
    }
    
    public PawnBuilder white() {
        return this;
    }

    public PawnBuilder on(String cell) {
        this.cell = cell;
        return this;
    }

    public Pawn build() {
        Pawn pawn = new Pawn();
        pawn.setPosition( cell );
        return pawn;
    }
}
