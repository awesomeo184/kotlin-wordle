package wordle

class Wordle(val words: Set<Word>) {

    fun tryMatch(word: Word) {
        if (!words.contains(word)) {
            throw IllegalArgumentException("목록에 존재하지 않는 단어입니다.")
        }
    }
}