package gui;

import org.junit.Before;
import org.junit.Test;

import static builders.BishopBuilder.aBishop;
import static builders.KingBuilder.aKing;
import static builders.KnightBuilder.aKnight;
import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static builders.RockBuilder.aRock;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class RendererFactoryTest {

    RendererFactory factory;
    
    @Before public void
    newFactory() {
        factory = new RendererFactory();
    }

    @Test public void
    queens() {
        assertThat( factory.rendererOf( aQueen().build()), instanceOf( QueenRenderer.class ) );
    }

    @Test public void
    pawns() {
        assertThat( factory.rendererOf( aPawn().build()), instanceOf( PawnRenderer.class ) );
    }

    @Test public void
    rocks() {
        assertThat( factory.rendererOf( aRock().build()), instanceOf( RoockRenderer.class ) );
    }

    @Test public void
    bishops() {
        assertThat( factory.rendererOf( aBishop().build()), instanceOf( BishopRenderer.class ) );
    }

    @Test public void
    knights() {
        assertThat( factory.rendererOf( aKnight().build()), instanceOf( KnightRenderer.class ) );
    }

    @Test public void
    kings() {
        assertThat( factory.rendererOf( aKing().build()), instanceOf( KingRenderer.class ) );
    }
}
