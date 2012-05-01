package piezas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Dama extends Pieza {

	public Dama(int x, int y) {
		super(x, y);
	}

	private List<Point> posicionesAlcanzables(int dx, int dy) {
		List<Point> ret = new ArrayList<Point>();

		for (int i = x + dx, j = y + dy; //
		/**/posicionValida(i, j); i += dx, j += dy) {
			ret.add(new Point(i, j));
		}

		return ret;
	}

	public List<Point> posicionesAlcanzables() {
		List<Point> ret = new ArrayList<Point>();

		ret.addAll(posicionesAlcanzables(+0, -1));
		ret.addAll(posicionesAlcanzables(+1, -1));
		ret.addAll(posicionesAlcanzables(+1, +0));
		ret.addAll(posicionesAlcanzables(+1, +1));
		ret.addAll(posicionesAlcanzables(+0, +1));
		ret.addAll(posicionesAlcanzables(-1, +1));
		ret.addAll(posicionesAlcanzables(-1, +0));
		ret.addAll(posicionesAlcanzables(-1, -1));

		return ret;
	}
}
