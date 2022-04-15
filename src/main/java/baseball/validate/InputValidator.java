package baseball.validate;

public class InputValidator {

    public static void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + "자리 수를 입력하세요");
        }
    }

    public static void validateNumbers(String input) {
        char[] chAry = input.toCharArray();
        for (char ch : chAry) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void validateContainString(String input, String... args) {
        int size = args.length;
        int matchCount = 0;
        for (String s : args) {
            if (s.equals(input)) matchCount++;
        }

        if (matchCount != 1) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
    }
}
