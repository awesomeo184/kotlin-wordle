package wordle.view

import wordle.domain.LetterResult
import wordle.domain.LetterResult.*
import wordle.domain.WordResult

private val emojiByLetterResult: Map<LetterResult, String> = mapOf(
    NONE to String(Character.toChars(0x2B1C)),
    EXIST to String(Character.toChars(0x1F7E8)),
    CORRECT to String(Character.toChars(0x1F7E9)),
)

fun printWordResult(wordResults: List<WordResult>) {
    for (wordResult in wordResults) {
        for (letterResult in wordResult.values) {
            print(emojiByLetterResult[letterResult])
        }
        println()
    }
    println()
}
