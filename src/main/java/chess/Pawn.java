package chess;

public class Pawn {

    private String cell;

    public void setPosition(String cell) {

        this.cell = cell;
    }

    public String getPosition() {
        return cell;
    }

    public String toString() {
        return "P";
    }
}
