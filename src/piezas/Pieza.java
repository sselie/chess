package piezas;

public class Pieza {

	protected int x;
	protected int y;

	/* true => dentro del tablero, false => fuera del tablero */
	public static boolean esPosicionValida(int x, int y) {
		return 0 <= x && x <= 7 && 0 <= y && y <= 7;
	}

	public Pieza(int x, int y) {
		if (!esPosicionValida( x, y )) {
			throw new IllegalArgumentException( //
					"!esPosicionValida(x, y): " + x + ", " + y);
		}

		this.x = x;
		this.y = y;
	}
}
