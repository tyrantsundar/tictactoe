package strategies.checkWinner;

import entities.Board;
import entities.Move;

public class CornerWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
