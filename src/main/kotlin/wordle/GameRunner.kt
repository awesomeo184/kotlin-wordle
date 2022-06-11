package wordle

import wordle.domain.Word
import wordle.domain.Wordle
import wordle.view.printWordResult
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class GameRunner {

    fun run() {

        val wordsResourceReader = WordsResourceReader()
        val words = wordsResourceReader.readWords("src/main/resources/words.txt")
        val wordle = Wordle(words, calculateDays())

        var count = 6

        while (count-- != 0) {

            println("정답을 입력해주세요.")
            val matchResult = wordle.tryMatch(Word(readln()))
            printWordResult(matchResult)

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
}