package piezas;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static piezas.Pieza.esPosicionValida;

public class TestPieza {

    @Test public void
    sePuedeCrearUnaPiezzaDentroDelTablero() {
        new Pieza(0, 0);
        new Pieza(7, 0);
        new Pieza(7, 7);
        new Pieza(0, 7);
    }
    
	@Test public void
    noPuedeCrearUnaPiezzaAlExteriorDelTablero() {
		try {
			new Pieza(-1, -1);
			assertTrue(false);
		} catch (IllegalArgumentException e) {}
		try {
			new Pieza(+8, -1);
			assertTrue(false);
		} catch (IllegalArgumentException e) {}
		try {
			new Pieza(+8, +8);
			assertTrue(false);
		} catch (IllegalArgumentException e) {}
		try {
			new Pieza(-1, +8);
			assertTrue(false);
		} catch (IllegalArgumentException e) {}
	}

	@Test public void
    sePuedeVerificarSiUnaPositionEsValidaSinCrearUnaPiezza() {
		assertTrue( esPosicionValida( 0, 0 ));
		assertTrue( esPosicionValida( 7, 0 ) );
        assertTrue( esPosicionValida( 7, 7 ));
		assertTrue( esPosicionValida( 0, 7 ));

		assertFalse( esPosicionValida( -1, -1 ) );
		assertFalse( esPosicionValida( +8, -1 ));
		assertFalse( esPosicionValida( +8, +8 ) );
		assertFalse( esPosicionValida( -1, +8 ));
	}
}
