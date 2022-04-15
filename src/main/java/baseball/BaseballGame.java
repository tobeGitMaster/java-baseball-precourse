package baseball;

import baseball.controller.GameController;
import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private GameController gameController;

    public BaseballGame() {
        gameController = new GameController();
    }

    public void start() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String numbers = Console.readLine();

            GameResult gameResult = gameController.play(numbers);
            System.out.println(gameResult.getMessage());

            if (!processResult(gameResult)) break;
        }
    }

    public boolean processResult(GameResult gameResult) {
        boolean isLoop = true;
        if (gameResult.isWin()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isLoop = gameController.inquireReplay(Console.readLine());
        }

        return isLoop;
    }
}