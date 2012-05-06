package chess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Rey extends Pieza {

	public Rey(int x, int y) {
		super(x, y);
	}

	public List<Point> posicionesAlcanzables() {
		List<Point> ret = new ArrayList<Point>();

		for (int j = -1; j <= 1; j++) {
			for (int i = -1; i <= 1; i++) {
				int posX = x + i;
				int posY = y + j;

				if (i != 0 || j != 0) {
					if (esPosicionValida( posX, posY )) {
						ret.add(new Point(posX, posY));
					}
				}
			}
		}

		return ret;
	}

}
