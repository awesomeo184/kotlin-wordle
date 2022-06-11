package wordle

import wordle.LetterResult.*

class WordResult(val values: List<LetterResult>) {
    fun isAllCorrect(): Boolean {
        return values == listOf(CORRECT, CORRECT, CORRECT, CORRECT, CORRECT)
    }
}
