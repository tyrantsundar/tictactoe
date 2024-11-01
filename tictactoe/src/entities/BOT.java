package entities;

public class BOT extends Player{
    private BOT_DifficultyLevel difficultyLevel;

    public BOT(int id, String name, Symbol symbol, PlayerType playerType, BOT_DifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
}
