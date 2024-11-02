package entities;

public abstract class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public boolean validateMove(int row, int col, Board board){
        if(row < 0  || col < 0 || row >= board.getSize() || col >= board.getSize()){
            return false;
        }
        if(board.getGrid().get(row).get(col).getStatus().equals(CellStatus.FILL)){
            return false;
        }
        return true;
    }

    public abstract Move makeMove(Game game);
}
