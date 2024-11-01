import controller.GameController;
import entities.*;

import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Player sundar = new Human(1,"sundar", new Symbol('X', "Green"), PlayerType.HUMAN);
        Player bot = new BOT(2, "BOT", new Symbol('O', "Red"),PlayerType.BOT,BOT_DifficultyLevel.EASY);
        List<Player> playerList = new ArrayList<>();
        playerList.add(sundar);
        playerList.add(bot);

        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        winningStrategyList.add(WinningStrategy.ROW);
        winningStrategyList.add(WinningStrategy.COLUMN);

        Game game = gameController.startGame(3, playerList, winningStrategyList);
        gameController.display(game);

        while (game.getGameStatus() == GameStatus.IN_PROGRESS){
            gameController.makeMove(game);
            gameController.display(game);
        }

        if(game.getGameStatus() == GameStatus.SUCCESS){
            System.out.println("Winner is "+gameController.getWinner(game).getName());
        }else {
            System.out.println("Game Draw !!!");
        }
    }
}
