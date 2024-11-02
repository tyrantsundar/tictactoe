package strategies.checkWinner;

import entities.Board;
import entities.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer>> rowCharCountMap = new HashMap<>();
    private static RowWinningStrategy instance;

    private RowWinningStrategy(){}

    public static RowWinningStrategy getInstance(){
        if(instance == null){
            instance = new RowWinningStrategy();
        }
        return instance;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char symbolChar = move.getPlayer().getSymbol().getSymbolChar();

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

    @Override
    public void undo(Board board, Move move){
        int row = move.getCell().getRow();
        char symbolChar = move.getPlayer().getSymbol().getSymbolChar();
        Map<Character, Integer> charCountMap = rowCharCountMap.get(row);
        charCountMap.put(symbolChar, charCountMap.get(symbolChar)-1);
        rowCharCountMap.put(row,charCountMap);
    }
}
