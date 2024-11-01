package strategies.checkWinner;

import entities.Board;
import entities.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer>> colCharCountMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        char symbolChar = move.getCell().getSymbol().getSymbolChar();

        if(!colCharCountMap.containsKey(col)){
            colCharCountMap.put(col,new HashMap<>());
        }

        Map<Character, Integer> charCountMap = colCharCountMap.get(col);

        if(!charCountMap.containsKey(symbolChar)){
            charCountMap.put(symbolChar,0);
        }

        charCountMap.put(symbolChar, charCountMap.get(symbolChar)+1);
        colCharCountMap.put(col,charCountMap);

        if(charCountMap.get(symbolChar) == board.getSize()){
            return true;
        }
        return false;
    }
}
