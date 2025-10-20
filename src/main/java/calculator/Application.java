package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    // IllegalArgumentException을 main 메서드 밖으로 던지도록 유지합니다.
    public static void main(String[] args) throws IllegalArgumentException {
        // 🚨 이 메시지를 아래 try 블록 안으로 이동합니다.
        // System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            // 🚨 테스트 통과를 위해 메시지 출력 위치를 Console.readLine() 직전으로 옮깁니다.
            System.out.println("덧셈할 문자열을 입력해 주세요.");

            String input = Console.readLine();

            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);

            System.out.println("결과 : " + result);

        } catch (IllegalArgumentException e) {
            // 기능 요구 사항에 따라 System.err로 메시지를 출력합니다.
            // 그리고 예외를 밖으로 던져 테스트를 통과시킵니다.
            System.err.println("[에러] " + e.getMessage());
            throw e; // IllegalArgumentException을 다시 던져 테스트 프레임워크가 잡을 수 있게 합니다.

        } catch (Exception e) {
            // 기타 예상치 못한 오류 처리 (RuntimeException이 아닌 경우)
            System.err.println("[시스템 에러] " + e.getMessage());
            throw new RuntimeException(e);

        } finally {
            Console.close();
        }
    }
}