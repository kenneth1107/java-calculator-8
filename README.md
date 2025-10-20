# java-calculator-precourse

# 📚 문자열 덧셈 계산기 (String Calculator) 미션

## 🎯 학습 목표

* Git, GitHub, IDE 등 실제 개발 환경에 익숙해진다.
* 교육 분야에 맞는 프로그래밍 언어(Java)를 사용하여 간단한 문자열 처리 및 덧셈 문제를 해결한다.
* 기능 목록 기반의 체계적인 커밋 방식에 익숙해진다.

## 🛠️ 기능 구현 목록

본 미션은 입력 문자열에서 숫자를 추출하여 합계를 구하는 계산기를 구현하며, 다음 기능 요구 사항을 만족해야 합니다. 아래 목록은 **Git 커밋 단위**의 기준이 됩니다.

| No. | 기능 | 커밋 Type (예시) |
| :--- | :--- | :--- |
| **1** | **초기 값 처리** | `feat(parser)` |
| | 입력 문자열이 **`null`**이거나 **빈 문자열**(`""`)인 경우 **0**을 반환한다. | |
| **2** | **기본 구분자 처리** | `feat(parser)` |
| | **쉼표(`,`)** 또는 **콜론(`:`)** 을 구분자로 사용하여 분리된 숫자의 합을 계산한다. (예: `"1,2:3"` $\rightarrow$ 6) | |
| **3** | **커스텀 구분자 처리** | `feat(parser)` |
| | 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 문자를 **커스텀 구분자**로 사용한다. (예: `//;\n1;2;3` $\rightarrow$ 6) | |
| **4** | **잘못된 값 예외 처리** | `fix(validator)` |
| | 분리된 숫자에 **음수**가 포함되거나, **숫자가 아닌 문자열**이 포함된 경우 **`IllegalArgumentException`**을 발생시킨다. | |
| **5** | **입출력 및 최종 출력** | `feat(application)` |
| | `camp.nextstep.edu.missionutils.Console` API를 사용하여 입력을 받고, 최종 결과를 **"결과 : [숫자]"** 형식으로 출력한다. | |

## ⚙️ 실행 및 빌드 환경

* **Java 버전:** JDK 21
* **테스트 실행:** `./gradlew clean test` (Mac/Linux), `gradlew.bat clean test` (Windows)

## 📌 커밋 메시지 규칙

Git 커밋 메시지는 **AngularJS Git Commit Message Conventions**을 참고하여 작성했습니다.

| Type | 설명 | 예시 |
| :--- | :--- | :--- |
| **`feat`** | 새로운 기능 추가 | `feat(파서): '//(문자)\n' 형식의 커스텀 구분자 지원` |
| **`fix`** | 버그 수정 및 예외 처리 | `fix(유효성검사): 음수 입력 시 IllegalArgumentException 발생 처리` |
| **`refactor`** | 리팩터링 (기능 변경 없음) | `refactor(파서): 구분자 정규식을 문자 클래스 사용으로 변경` |
| **`style`** | 코드 스타일 관련 변경 | `style: 들여쓰기 4칸 및 120자 열 제한 적용` |
| **`chore`** | 빌드, 환경 설정, 라이브러리 등 유지보수 | `chore: StringCalculator의 불필요한 import 정리` |