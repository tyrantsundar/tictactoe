package strategies.bot_difficulty;

import entities.Board;
import entities.Game;
import entities.Move;
import entities.Player;

public interface Bot {
    public Move makeMove(Board board, Player player);
}
