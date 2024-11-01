package controller;

import entities.Game;
import entities.GameStatus;
import entities.Player;
import entities.WinningStrategy;

import java.util.List;

public class GameController {


    public Game startGame(int boardSize, List<Player> playerList, List<WinningStrategy> winningStrategyList){
        return Game.getBuilder()
                .setBoard(boardSize)
                .setPlayerList(playerList)
                .setWinningStrategyList(winningStrategyList)
                .build();
    }

    public void display(Game game){
        game.display();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void makeMove(Game game){

    }
}
