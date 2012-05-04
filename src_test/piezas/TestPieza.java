package piezas;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPieza {

    @Test public void
    sePuedeCrearUnaPiezzaDentroDelTablero() {
        new Pieza(0, 0);
        new Pieza(7, 0);
        new Pieza(7, 7);
        new Pieza(0, 7);
    }
    
	@Test
	public void noPuedeCrearUnaPiezzaAlExteriorDelTablero() {
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

	@Test
	public void testPosicionValida() {
		assertTrue(Pieza.posicionValida(0, 0));
		assertTrue(Pieza.posicionValida(7, 0));
		assertTrue(Pieza.posicionValida(7, 7));
		assertTrue(Pieza.posicionValida(0, 7));

		assertFalse(Pieza.posicionValida(-1, -1));
		assertFalse(Pieza.posicionValida(+8, -1));
		assertFalse(Pieza.posicionValida(+8, +8));
		assertFalse(Pieza.posicionValida(-1, +8));
	}
}
