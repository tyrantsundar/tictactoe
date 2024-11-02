package entities;

import strategies.bot_difficulty.Bot;
import strategies.bot_difficulty.BotDifficultyFactory;

public class BOT extends Player{
    private BOT_DifficultyLevel difficultyLevel;

    public BOT(int id, String name, Symbol symbol, PlayerType playerType, BOT_DifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Game game) {
        Bot bot = BotDifficultyFactory.getBotDifficultyLevel(difficultyLevel);
        return bot.makeMove(game.getBoard(),this);
    }
}
