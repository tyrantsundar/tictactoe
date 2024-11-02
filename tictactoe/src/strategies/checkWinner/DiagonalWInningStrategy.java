package strategies.checkWinner;

import entities.Board;
import entities.Move;

public class DiagonalWInningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }

    @Override
    public void undo(Board board, Move move) {

    }
}
