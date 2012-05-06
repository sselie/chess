package chess;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

public class TestRey {

	@Test
	public void testPosicionesAlcanzables() {
		Rey p = new Rey(4, 4);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(8, pos.size());

		assertTrue(pos.contains(new Point(3, 3)));
		assertTrue(pos.contains(new Point(4, 3)));
		assertTrue(pos.contains(new Point(5, 3)));
		assertTrue(pos.contains(new Point(3, 4)));
		assertTrue(pos.contains(new Point(5, 4)));
		assertTrue(pos.contains(new Point(3, 5)));
		assertTrue(pos.contains(new Point(4, 5)));
		assertTrue(pos.contains(new Point(5, 5)));
	}

	@Test
	public void testPosicionesAlcanzablesExtremoSupIzq() {
		Rey p = new Rey(0, 0);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(3, pos.size());

		assertTrue(pos.contains(new Point(0, 1)));
		assertTrue(pos.contains(new Point(1, 0)));
		assertTrue(pos.contains(new Point(1, 1)));
	}

	@Test
	public void testPosicionesAlcanzablesExtremoInfIzq() {
		Rey p = new Rey(0, 7);

		List<Point> pos = p.posicionesAlcanzables();

		assertEquals(3, pos.size());

		assertTrue(pos.contains(new Point(0, 6)));
		assertTrue(pos.contains(new Point(1, 7)));
		assertTrue(pos.contains(new Point(1, 6)));
	}
}
