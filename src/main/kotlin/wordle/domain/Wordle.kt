package wordle.domain

class Wordle(private val words: List<Word>, days: Int) {

    val matchResults = mutableListOf<WordResult>()

    private val answer = Answer(words[days % words.size])

    fun tryMatch(word: Word): WordResult {
        if (!words.contains(word)) {
            throw IllegalArgumentException("목록에 존재하지 않는 단어입니다.")
        }

        val wordResult = answer.match(word)
        matchResults.add(wordResult)
        return wordResult
    }

    fun isTrialRemain(): Boolean {
        return matchResults.size < TRIAL_LIMIT
    }

    fun currentTrialCount(): Int {
        return matchResults.size
    }

    companion object {
        const val TRIAL_LIMIT = 6
    }
}
