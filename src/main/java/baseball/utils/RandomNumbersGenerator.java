package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {

    // 랜덤 숫자 발생
    public static List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(random)) {
                randomNumbers.add(random);
            }
        }

        return randomNumbers;
    }

}
