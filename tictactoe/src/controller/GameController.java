package controller;

import entities.Game;
import entities.GameStatus;
import entities.Player;
import entities.Strategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {


    public Game startGame(int boardSize, List<Player> playerList, List<Strategy> strategyList){
        return Game.getBuilder()
                .setBoard(boardSize)
                .setPlayerList(playerList)
                .setGameStatus(GameStatus.IN_PROGRESS)
                .setMoveList(new ArrayList<>())
                .setWinningStrategyList(strategyList)
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
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }
}
