import static chess.rules.InitialPositions.initialPositions;
import gui.GameFrame;
import chess.Game;

public class Launcher {

    public static void main(final String... arg)
    {
        final Game game = new Game();

        final GameFrame frame = new GameFrame(game);
        frame.setVisible( true );

        frame.display( initialPositions() );
    }
}
