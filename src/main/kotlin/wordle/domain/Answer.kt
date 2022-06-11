package wordle.domain

class Answer(private val word: Word) {

    fun match(trial: Word): WordResult {

        val wordCounter = word.wordCounter()
        val results = MutableList(5) { LetterResult.NONE }

        for (i in 0..4) {
            if (word.value[i] == trial.value[i]) {
                val count = wordCounter[trial.value[i]]?:0
                if (count > 0) {
                    results[i] = LetterResult.CORRECT
                    wordCounter[trial.value[i]] = count - 1
                }
            }
        }

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