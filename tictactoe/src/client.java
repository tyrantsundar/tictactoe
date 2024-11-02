import controller.GameController;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameController gameController = new GameController();

        Player sundar = new Human(1,"Sundar", new Symbol('X', "Green"), PlayerType.HUMAN);
        Player bot = new BOT(2, "BOT", new Symbol('O', "Red"),PlayerType.BOT,BOT_DifficultyLevel.EASY);

        List<Player> playerList = new ArrayList<>();
        playerList.add(sundar);
        playerList.add(bot);

        List<Strategy> strategyList = new ArrayList<>();
        strategyList.add(Strategy.ROW);
        strategyList.add(Strategy.COLUMN);

        Game game = gameController.startGame(3, playerList, strategyList);
        gameController.display(game);

        while (game.getGameStatus() == GameStatus.IN_PROGRESS){
            gameController.makeMove(game);
            gameController.display(game);

            System.out.println("Do you want to undo (Y/N)");
            String undo = scanner.nextLine();
            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                gameController.display(game);
            }
        }

        if(game.getGameStatus() == GameStatus.SUCCESS){
            System.out.println("Winner is "+gameController.getWinner(game).getName());
        }else {
            System.out.println("Game Draw !!!");
        }
    }
}
