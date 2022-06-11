package wordle

import wordle.domain.Word
import wordle.domain.Wordle
import wordle.view.printStartMessage
import wordle.view.printTrialMessage
import wordle.view.printWordResult
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class GameRunner {

    fun run() {
        val wordle = Wordle(WordsResourceReader().readWords(WORD_LIST_PATH), calculateDays())

        printStartMessage()
        do {
            printTrialMessage()
            wordle.tryMatch(Word(readln()))
            printWordResult(wordle)
        } while (wordle.isEnd())
    }

    private fun calculateDays(): Int {
        return ChronoUnit.DAYS.between(START_DATE_TIME, LocalDateTime.now()).toInt()
    }

    private companion object {
        private const val WORD_LIST_PATH = "src/main/resources/words.txt"
        private val START_DATE_TIME = LocalDateTime.of(2021, 6, 19, 0, 0, 0)
    }
}