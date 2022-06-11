package wordle.domain

class Answer(private val word: Word) {

    fun match(trial: Word): WordResult {

        val wordCounter = word.wordCounter()
        val results = MutableList(5) { LetterResult.NONE }

        // word랑 trial에서 일치하는 인덱스만 받아옴 (0, 1, 3)
        // 0, 1, 3에 correct 집어 넣기
        // 0, 1, 3의 counter 감소

        for (i in 0..4) {
            if (word.value[i] == trial.value[i]) {
                val count = wordCounter[trial.value[i]]?:0
                if (count > 0) {
                    results[i] = LetterResult.CORRECT
                    wordCounter[trial.value[i]] = count - 1
                }
            }
        }

        // result = none인 인덱스만 검사 (2, 4)
        // 2, 4에 대해서 아래 로직 실행

        for (i in 0..4) {
            if (word.value[i] != trial.value[i]) {
                val count = wordCounter[trial.value[i]]?:0
                if (count > 0) {
                    results[i] = LetterResult.EXIST
                    wordCounter[trial.value[i]] = count - 1
                }
            }
        }
        return WordResult(results)
    }
}