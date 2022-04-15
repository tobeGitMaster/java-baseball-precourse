package baseball.controller;

import baseball.model.GameResult;
import baseball.service.GameService;

public class GameController {

    private GameService gameService;

    public GameController() {
        gameService = new GameService();
    }

    public GameResult play(String numbers) {
        return gameService.process(numbers);
    }

    public boolean inquireReplay(String input) {
        return gameService.isReplay(input);
    }

}
