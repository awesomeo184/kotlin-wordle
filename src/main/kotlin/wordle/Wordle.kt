package wordle

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Wordle(val words: List<Word>) {

    val answer: Word = calculateAnswer()

    fun tryMatch(word: Word) {
        if (!words.contains(word)) {
            throw IllegalArgumentException("목록에 존재하지 않는 단어입니다.")
        }
    }

    private fun calculateAnswer(): Word {
        val today: LocalDateTime = LocalDateTime.now()
        val date: LocalDateTime = LocalDateTime.of(2021, 6, 19, 0, 0, 0)
        val days: Long = ChronoUnit.DAYS.between(date, today)
        return words[days.toInt() % words.size]
    }
}
