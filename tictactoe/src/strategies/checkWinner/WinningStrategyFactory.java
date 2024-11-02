package strategies.checkWinner;

import entities.Strategy;

public class WinningStrategyFactory {

    public static WinningStrategy getWinningStrategy(Strategy strategy){
        switch (strategy){
            case ROW: return RowWinningStrategy.getInstance();
            case COLUMN: return ColumnWinningStrategy.getInstance();
            case DIAGONAL: return new DiagonalWInningStrategy();
            case CORNER: return new CornerWinningStrategy();
        }
        return null;
    }
}
