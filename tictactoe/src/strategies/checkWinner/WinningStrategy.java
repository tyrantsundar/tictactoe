package strategies.checkWinner;

import entities.Board;
import entities.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
    public void undo(Board board, Move move);
}
