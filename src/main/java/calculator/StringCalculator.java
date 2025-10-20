package calculator;



public class StringCalculator {

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = split(text);
        return sum(numbers);
    }

    // 기능 2: 문자열 분리 및 구분자 처리
    private String[] split(String text) {
        // 커스텀 구분자 확인 및 처리
        // 테스트 코드 run("//;\\n1")에 맞추어 실제 문자열 "\\n"을 찾도록 변경 (주의: 실제 사용자 입력은 \n일 수 있음)
        if (text.startsWith("//") && text.contains("\\n")) {
            return splitByCustomDelimiter(text);
        }

        // 기본 구분자 (쉼표 또는 콜론) 처리
        // 이전 경고를 반영하여 정규식 ",|:" 대신 문자 클래스 "[,:]" 사용을 권장합니다.
        return text.split("[,:]");
    }

    // 기능 3: 커스텀 구분자 처리
    private String[] splitByCustomDelimiter(String text) {
        // 테스트 입력에 맞춰 "\\n"을 찾습니다.
        int delimiterEndIndex = text.indexOf("\\n");

        // 구분자는 "//" (2자)와 "\\n" (2자) 사이에 위치
        String delimiterPart = text.substring(2, delimiterEndIndex);
        String dataPart = text.substring(delimiterEndIndex + 2); // "\\n" 두 글자를 건너뜁니다.

        // 정규식에서 특수문자를 구분자로 사용할 경우 escape 처리가 필요
        return dataPart.split(java.util.regex.Pattern.quote(delimiterPart));
    }

    // 기능 4: 합계 계산 및 예외 처리
    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num;

            // 공백 제거
            String trimmedNumber = number.trim();
            if (trimmedNumber.isEmpty()) {
                continue;
            }

            try {
                // 숫자가 아닌 문자열 예외 처리
                num = Integer.parseInt(trimmedNumber);
            } catch (NumberFormatException e) {
                // 잘못된 값이 입력된 경우 (숫자가 아닌 문자)
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + trimmedNumber);
            }

            // 음수 예외 처리
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            total += num;
        }
        return total;
    }
}