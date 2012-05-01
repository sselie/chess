package piezas;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

public class TestDama {

	@Test
	public void testPosicionesAlcanzables() {
		Dama p = new Dama(4, 4);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(27, pos.size());

		assertTrue(pos.contains(new Point(3, 3)));
		assertTrue(pos.contains(new Point(2, 2)));
		assertTrue(pos.contains(new Point(1, 1)));
		assertTrue(pos.contains(new Point(0, 0)));

		assertTrue(pos.contains(new Point(4, 3)));
		assertTrue(pos.contains(new Point(4, 2)));
		assertTrue(pos.contains(new Point(4, 1)));
		assertTrue(pos.contains(new Point(4, 0)));

		assertTrue(pos.contains(new Point(5, 3)));
		assertTrue(pos.contains(new Point(6, 2)));
		assertTrue(pos.contains(new Point(7, 1)));

		assertTrue(pos.contains(new Point(5, 4)));
		assertTrue(pos.contains(new Point(6, 4)));
		assertTrue(pos.contains(new Point(7, 4)));

		assertTrue(pos.contains(new Point(5, 5)));
		assertTrue(pos.contains(new Point(6, 6)));
		assertTrue(pos.contains(new Point(7, 7)));

		assertTrue(pos.contains(new Point(4, 5)));
		assertTrue(pos.contains(new Point(4, 6)));
		assertTrue(pos.contains(new Point(4, 7)));

		assertTrue(pos.contains(new Point(3, 5)));
		assertTrue(pos.contains(new Point(2, 6)));
		assertTrue(pos.contains(new Point(1, 7)));

		assertTrue(pos.contains(new Point(3, 4)));
		assertTrue(pos.contains(new Point(2, 4)));
		assertTrue(pos.contains(new Point(1, 4)));
		assertTrue(pos.contains(new Point(0, 4)));
	}

	@Test
	public void testPosicionesAlcanzablesExtremoSupIzq() {
		Dama p = new Dama(0, 0);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(21, pos.size());

		assertTrue(pos.contains(new Point(1, 0)));
		assertTrue(pos.contains(new Point(2, 0)));
		assertTrue(pos.contains(new Point(3, 0)));
		assertTrue(pos.contains(new Point(4, 0)));
		assertTrue(pos.contains(new Point(5, 0)));
		assertTrue(pos.contains(new Point(6, 0)));
		assertTrue(pos.contains(new Point(7, 0)));

		assertTrue(pos.contains(new Point(0, 1)));
		assertTrue(pos.contains(new Point(0, 2)));
		assertTrue(pos.contains(new Point(0, 3)));
		assertTrue(pos.contains(new Point(0, 4)));
		assertTrue(pos.contains(new Point(0, 5)));
		assertTrue(pos.contains(new Point(0, 6)));
		assertTrue(pos.contains(new Point(0, 7)));

		assertTrue(pos.contains(new Point(1, 1)));
		assertTrue(pos.contains(new Point(2, 2)));
		assertTrue(pos.contains(new Point(3, 3)));
		assertTrue(pos.contains(new Point(4, 4)));
		assertTrue(pos.contains(new Point(5, 5)));
		assertTrue(pos.contains(new Point(6, 6)));
		assertTrue(pos.contains(new Point(7, 7)));
	}

	@Test
	public void testPosicionesAlcanzablesExtremoInfIzq() {
		Dama p = new Dama(0, 7);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(21, pos.size());

		assertTrue(pos.contains(new Point(1, 7)));
		assertTrue(pos.contains(new Point(2, 7)));
		assertTrue(pos.contains(new Point(3, 7)));
		assertTrue(pos.contains(new Point(4, 7)));
		assertTrue(pos.contains(new Point(5, 7)));
		assertTrue(pos.contains(new Point(6, 7)));
		assertTrue(pos.contains(new Point(7, 7)));

		assertTrue(pos.contains(new Point(0, 0)));
		assertTrue(pos.contains(new Point(0, 1)));
		assertTrue(pos.contains(new Point(0, 2)));
		assertTrue(pos.contains(new Point(0, 3)));
		assertTrue(pos.contains(new Point(0, 4)));
		assertTrue(pos.contains(new Point(0, 5)));
		assertTrue(pos.contains(new Point(0, 6)));

		assertTrue(pos.contains(new Point(1, 6)));
		assertTrue(pos.contains(new Point(2, 5)));
		assertTrue(pos.contains(new Point(3, 4)));
		assertTrue(pos.contains(new Point(4, 3)));
		assertTrue(pos.contains(new Point(5, 2)));
		assertTrue(pos.contains(new Point(6, 1)));
		assertTrue(pos.contains(new Point(7, 0)));
	}
}
