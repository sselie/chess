package builders;

import chess.Piece;

public abstract class PieceBuilder<T extends Piece>
{
    protected String cell;
    protected boolean white;

    public PieceBuilder()
    {
        super();
    }

    public PieceBuilder<T> white()
    {
        this.white = true;
        return this;
    }

    public PieceBuilder<T> black()
    {
        this.white = false;
        return this;
    }

    public PieceBuilder<T> on(final String cell)
    {
        this.cell = cell;
        return this;
    }

    protected abstract T getPiece();

    public T build() {
        final T piece = getPiece();
        piece.setPosition( cell );
        piece.setWhite( white );
        return piece;
    }
}