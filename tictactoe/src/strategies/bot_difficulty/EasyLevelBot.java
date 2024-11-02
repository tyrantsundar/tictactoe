package strategies.bot_difficulty;

import entities.*;

import java.util.List;

public class EasyLevelBot implements Bot{
    @Override
    public Move makeMove(Board board, Player player) {
        for (List<Cell> row :  board.getGrid()){
            for (Cell cell : row){
                if(cell.getStatus() == CellStatus.EMPTY){
                    return new Move(player,cell);
                }
            }
        }
        return null;
    }
}
