package entities;

import java.util.List;
import java.util.Locale;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private Player winner;
    private List<WinningStrategy> winningStrategyList;

    private Game(){}

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void display(){
        this.board.display();
    }

    public static class Builder {
        private Board board;
        private List<Player> playerList;
        private List<Move> moveList;
        private GameStatus gameStatus;
        private Player winner;
        private List<WinningStrategy> winningStrategyList;

        public Builder setBoard(int boardSize) {
            this.board = new Board(boardSize);
            return this;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setMoveList(List<Move> moveList) {
            this.moveList = moveList;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Game build(){
            Game game = new Game();
            game.setBoard(this.board);
            game.setGameStatus(this.gameStatus);
            game.setMoveList(this.moveList);
            game.setWinningStrategyList(this.winningStrategyList);
            game.setWinner(this.winner);
            game.setPlayerList(this.playerList);
            return game;
        }
    }
}
