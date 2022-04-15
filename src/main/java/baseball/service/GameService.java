package baseball.service;

import baseball.model.GameResult;
import baseball.utils.RandomNumbersGenerator;

import java.util.List;

public class GameService {

    private List<Integer> randomNumbers;
    private GameResult gameResult;

    public GameService() {
        init();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    private void init() {
        randomNumbers = RandomNumbersGenerator.generate();
    }

    /**
     * 게임 처리
     */
    public GameResult process(String input) {
        gameResult = new GameResult();
        for (int idx = 0; idx < input.length(); idx++) {
            int num = Integer.parseInt(input.substring(idx, idx + 1));
            containsNumber(num, idx);
        }

        return gameResult;
    }

    private void containsNumber(int num, int idx) {
        // 숫자 존재하지 않은 경우
        if (!randomNumbers.contains(num)) {
            return;
        }

        // 숫자와 위치 일치
        if (randomNumbers.indexOf(num) == idx) {
            gameResult.addStrikeCount();
            return;
        }

        // 랜덤 숫자는 존재하나 위치 일치하지 않는 경우
        if (randomNumbers.indexOf(num) != idx) {
            gameResult.addBallCount();
        }
    }

    /**
     * 재시작 확인
     */
    public boolean isReplay(String input) {

        if ("2".equals(input)) {
            return false;
        }

        if ("1".equals(input)) {
            init();
            return true;
        }

        return false;
    }

}
