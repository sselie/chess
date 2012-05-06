package chess;

public class Pawn {

    private String cell;
    private boolean white;

    public void setPosition(String cell) {

        this.cell = cell;
    }

    public String getPosition() {
        return cell;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }
}
