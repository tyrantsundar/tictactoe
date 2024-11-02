package entities;

import strategies.checkWinner.WinningStrategy;
import strategies.checkWinner.WinningStrategyFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private Player winner;
    private List<Strategy> strategyList;
    private int nextPlayerIndex;

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

    public void setWinningStrategyList(List<Strategy> strategyList) {
        this.strategyList = strategyList;
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

    public List<Strategy> getWinningStrategyList() {
        return strategyList;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void display(){
        this.board.display();
    }

    public void makeMove(){
        Player currPlayer = playerList.get(nextPlayerIndex);
        System.out.println("It's your turn : "+currPlayer.getName());
        Move move = currPlayer.makeMove(this);

        move.getCell().setStatus(CellStatus.FILL);
        move.getCell().setSymbol(currPlayer.getSymbol());

        for(Strategy strategy : strategyList){
            WinningStrategy winStrategy = WinningStrategyFactory.getWinningStrategy(strategy);
            boolean isWinnerExist = winStrategy.checkWinner(board,move);

            if(isWinnerExist){
                gameStatus = GameStatus.SUCCESS;
                winner = currPlayer;
            }

        }
        moveList.add(move);

        if(gameStatus != GameStatus.SUCCESS && moveList.size() == board.getSize() * board.getSize()){
            gameStatus = GameStatus.DRAW;
        }

        nextPlayerIndex++;
        nextPlayerIndex %= playerList.size();
    }

    public void undo(){
        Move lastMove = moveList.get(moveList.size()-1);
        moveList.remove(moveList.size()-1);

        Cell cell = lastMove.getCell();
        cell.setStatus(CellStatus.EMPTY);
        cell.setSymbol(null);

        for(Strategy strategy : strategyList){
            WinningStrategy winStrategy = WinningStrategyFactory.getWinningStrategy(strategy);
            winStrategy.undo(board,lastMove);
        }

        nextPlayerIndex = (nextPlayerIndex-1+playerList.size()) % playerList.size();

        gameStatus = GameStatus.IN_PROGRESS;
        winner = null;
    }

    public static class Builder {
        private Board board;
        private List<Player> playerList;
        private List<Move> moveList;
        private GameStatus gameStatus;
        private Player winner;
        private List<Strategy> strategyList;

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

        public Builder setWinningStrategyList(List<Strategy> strategyList) {
            this.strategyList = strategyList;
            return this;
        }

        public void isValid(){
            int botCount = 0;
            Set<Character> playerSymbolSet = new HashSet<>();
            Set<String> playersNameSet = new HashSet<>();
            for(Player player : playerList){
                if(player instanceof BOT){
                    botCount++;
                }
                if(playerSymbolSet.contains(player.getSymbol().getSymbolChar())){
                    throw new RuntimeException("Symbol cant be same for two players.");
                }
                if(playersNameSet.contains(player.getName())){
                    throw new RuntimeException("Name cant be same for two players.");
                }
                playerSymbolSet.add(player.getSymbol().getSymbolChar());
                playersNameSet.add(player.getName());
            }
            if(botCount > 1){
                throw new RuntimeException("We cant have more than 1 BOT !!!");
            }

            if(playerList.size() > board.getSize()){
                throw new RuntimeException("Player size cant be more than board dimension.");
            }
        }

        public Game build(){
            isValid();
            Game game = new Game();
            game.setBoard(this.board);
            game.setGameStatus(this.gameStatus);
            game.setMoveList(this.moveList);
            game.setWinningStrategyList(this.strategyList);
            game.setWinner(this.winner);
            game.setPlayerList(this.playerList);
            return game;
        }
    }
}
