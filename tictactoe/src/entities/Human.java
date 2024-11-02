package entities;

import java.util.Scanner;

public class Human extends Player{
    Scanner scanner = new Scanner(System.in);

    public Human(int id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
    }

    @Override
    public Move makeMove(Game game) {
        System.out.println("Enter the row ");
        int row = scanner.nextInt();
        System.out.println("Enter the column ");
        int col = scanner.nextInt();

        if(!validateMove(row,col,game.getBoard())){
            throw new RuntimeException("Invalid Cell");
        }

        Cell cell = game.getBoard().getGrid().get(row).get(col);
        return new Move(this,cell);
    }


}
