package wordle

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Wordle(private val words: List<Word>, days: Int) {

    private val answer: Answer = Answer(words[days % words.size])

    fun tryMatch(word: Word): WordResult {
        if (!words.contains(word)) {
            throw IllegalArgumentException("목록에 존재하지 않는 단어입니다.")
        }
        return answer.match(word)
    }
}
