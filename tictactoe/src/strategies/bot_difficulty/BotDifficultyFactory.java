package strategies.bot_difficulty;

import entities.BOT_DifficultyLevel;

public class BotDifficultyFactory {

    public static Bot getBotDifficultyLevel(BOT_DifficultyLevel botDifficultyLevel){
        switch (botDifficultyLevel){
            case EASY: return new EasyLevelBot();
            case MEDIUM: return new MediumLevelBot();
            case HARD: return new HardLevelBot();
        }
        return null;
    }
}
