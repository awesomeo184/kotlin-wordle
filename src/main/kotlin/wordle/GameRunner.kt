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
        while (wordle.isTrialRemain()) {
            printTrialMessage()
            val matchResult = wordle.tryMatch(Word(readln()))
            printWordResult(wordle.matchResults)

            if (matchResult.isAllCorrect()) {
                break
            }
        }
    }

    private fun calculateDays(): Int {
        val today: LocalDateTime = LocalDateTime.now()
        val date: LocalDateTime = LocalDateTime.of(2022, 6, 10, 0, 0, 0)
        val days: Long = ChronoUnit.DAYS.between(date, today)
        return days.toInt()
    }

    private companion object {
        private const val WORD_LIST_PATH = "src/main/resources/words.txt"
    }
}