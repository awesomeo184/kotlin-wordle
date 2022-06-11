# 미션 - 워들

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

---

## 🚀 기능 요구 사항

선풍적인 인기를 끌었던 영어 단어 맞추기 게임이다.

- 6x5 격자를 통해서 5글자 단어를 6번 만에 추측한다.
- 플레이어가 답안을 제출하면 프로그램이 정답과 제출된 단어의 각 알파벳 종류와 위치를 비교해 판별한다.
- 판별 결과는 흰색의 타일이 세 가지 색(초록색/노란색/회색) 중 하나로 바뀌면서 표현된다.
   - 맞는 글자는 초록색, 위치가 틀리면 노란색, 없으면 회색
   - 두 개의 동일한 문자를 입력하고 그중 하나가 회색으로 표시되면 해당 문자 중 하나만 최종 단어에 나타난다.
- 정답과 답안은 `words.txt`에 존재하는 단어여야 한다.
- 정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다.


## 구현 기능 목록

사용자 입력

- [ ] 사용자로부터 단어를 입력받는다.

출력

- [ ] 답안과 정답을 비교하여 결과를 출력한다.
  - [ ] 예외 상황 발생 시 예외 메시지를 출력한다.
  
도메인

- [x] 답안은 words.txt에 존재하는 단어여야한다.
- [x] 정답과 답안을 비교해 결과를 계산한다.
- [ ] 정답을 맞추면 게임이 종료된다.
- [ ] 답안을 제출할 기회는 6번이다.
- [x] 날짜를 통해 오늘의 정답을 선택한다.


## 설계

Answer
 - 정답을 알고 있다.
 - 답안과 정답을 비교해서 결과를 계산한다.
 
Word
 - 정답과 답안을 표현하는 책임

Wordle
  - 게임 전체 흐름을 제어하는 책임
  
### 고민할 사항

WordPool을 만들어서, 존재하는 단어인지 검증하고 Word로 감싸서 반환하도록 하는건 어떨까?

### 입출력 요구 사항

#### 실행 결과 예시

```
WORDLE을 6번 만에 맞춰 보세요.
시도의 결과는 타일의 색 변화로 나타납니다.
정답을 입력해 주세요.
hello

⬜⬜🟨🟩⬜

정답을 입력해 주세요.
label

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩

정답을 입력해 주세요.
spell

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩
🟩🟩⬜🟩🟩

정답을 입력해 주세요.
spill

4/6

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩
🟩🟩⬜🟩🟩
🟩🟩🟩🟩🟩
```
