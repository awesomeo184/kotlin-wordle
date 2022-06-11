package wordle.domain

import wordle.domain.LetterResult.CORRECT

class WordResult(val values: List<LetterResult>) {
    fun isAllCorrect(): Boolean {
        return values == listOf(CORRECT, CORRECT, CORRECT, CORRECT, CORRECT)
    }
}
