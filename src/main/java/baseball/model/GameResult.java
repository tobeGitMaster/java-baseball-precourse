package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private int ballCount;
    private int strikeCount;

    public GameResult() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public boolean isWin() {
        if (strikeCount == 3) {
            return true;
        }

        return false;
    }

    public String getMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        List<String> messages = new ArrayList<>();
        if (ballCount > 0) {
            messages.add(ballCount + "볼");
        }

        if (strikeCount > 0) {
            messages.add(strikeCount + "스트라이크");
        }

        return String.join(" ", messages);
    }

}
