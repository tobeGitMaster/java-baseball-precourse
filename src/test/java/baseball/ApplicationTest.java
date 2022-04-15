package baseball;

import baseball.model.GameResult;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 서로다른3개숫자_생성확인_테스트() {
        // given
        GameService gameService = new GameService();
        List<Integer> numbers = gameService.getRandomNumbers();

        // when
        // 숫자 중복 제거
        Set<Integer> set = new HashSet<>(numbers);

        // then
        assertThat(set.size()).isEqualTo(numbers.size());
    }


    @Test
    void _3볼테스트() {
        // given
        GameService gameService = new GameService();
        List<Integer> numbers = gameService.getRandomNumbers();

        // 순서 바꾸기
        List<Integer> numbers_copy = new ArrayList<>(numbers);
        numbers_copy.add(0, numbers_copy.remove(2));

        String input = "";
        for (int i : numbers_copy) input += i;

        // when
        GameResult gameResult = gameService.process(input);

        // then
        Assertions.assertThat("3볼").isEqualTo(gameResult.getMessage());
    }

    @Test
    void 특수문자_입력예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12#"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void _0입력예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
