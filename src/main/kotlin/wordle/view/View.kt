package wordle.view

import wordle.domain.LetterResult
import wordle.domain.LetterResult.*
import wordle.domain.Wordle

private val emojiByLetterResult: Map<LetterResult, String> = mapOf(
    NONE to String(Character.toChars(0x2B1C)),
    EXIST to String(Character.toChars(0x1F7E8)),
    CORRECT to String(Character.toChars(0x1F7E9)),
)

fun printStartMessage() {
    println("WORDLE을 ${Wordle.TRIAL_LIMIT}번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.")
}

fun printTrialMessage() {
    println("정답을 입력해주세요.")
}

fun printWordResult(wordle: Wordle) {
    if (wordle.isAllCorrect()) {
        printTotalTrialCount(wordle.currentTrialCount())
    }

    for (wordResult in wordle.matchResults) {
        println(wordResult.values.map { emojiByLetterResult[it] }.joinToString(separator = ""))
    }
    println()
}

fun printTotalTrialCount(count: Int) {
    println("${count}/${Wordle.TRIAL_LIMIT}\n")
}
