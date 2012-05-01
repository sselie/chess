package piezas;

public class Pieza {

	protected int x;
	protected int y;

	/* true => dentro del tablero, false => fuera del tablero */
	public static boolean posicionValida(int x, int y) {
		return 0 <= x && x <= 7 && 0 <= y && y <= 7;
	}

	public Pieza(int x, int y) {
		if (!posicionValida(x, y)) {
			throw new IllegalArgumentException( //
					"!posicionValida(x, y): " + x + ", " + y);
		}

		this.x = x;
		this.y = y;
	}
}
