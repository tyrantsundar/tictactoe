package strategies.checkWinner;

import entities.Board;
import entities.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer>> rowCharCountMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char symbolChar = move.getCell().getSymbol().getSymbolChar();

        if(!rowCharCountMap.containsKey(row)){
            rowCharCountMap.put(row,new HashMap<>());
        }

        Map<Character, Integer> charCountMap = rowCharCountMap.get(row);

        if(!charCountMap.containsKey(symbolChar)){
            charCountMap.put(symbolChar,0);
        }

        charCountMap.put(symbolChar, charCountMap.get(symbolChar)+1);
        rowCharCountMap.put(row,charCountMap);

        if(charCountMap.get(symbolChar) == board.getSize()){
            return true;
        }
        return false;
    }

}
