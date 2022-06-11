package wordle

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import wordle.domain.LetterResult.*
import wordle.domain.Answer
import wordle.domain.Word
import wordle.domain.WordResult

class AnswerTest : StringSpec({

    "정답과 답안을 비교하여 결과를 계산한다" {
        val answer = Answer(Word("brown"))
        listOf(
            Word("xxxxx") to WordResult(listOf(NONE, NONE, NONE, NONE, NONE)),
            Word("brxxx") to WordResult(listOf(CORRECT, CORRECT, NONE, NONE, NONE)),
            Word("xbxxx") to WordResult(listOf(NONE, EXIST, NONE, NONE, NONE)),
            Word("xbbxx") to WordResult(listOf(NONE, EXIST, NONE, NONE, NONE)),
            Word("xxbxx") to WordResult(listOf(NONE, NONE, EXIST, NONE, NONE)),
            Word("rownb") to WordResult(listOf(EXIST, EXIST, EXIST, EXIST, EXIST)),
            Word("brown") to WordResult(listOf(CORRECT, CORRECT, CORRECT, CORRECT, CORRECT)),

        ).forAll { (trial, result) ->
            answer.match(trial).values shouldBe result.values
        }
    }

    "정답과 답안을 비교하여 결과를 계산한다2" {
        val answer = Answer(Word("xaaxx"))
        listOf(
            Word("zzazz") to WordResult(listOf(NONE, NONE, CORRECT, NONE, NONE)),
            Word("aaazz") to WordResult(listOf(NONE, CORRECT, CORRECT, NONE, NONE)),
            Word("azzaa") to WordResult(listOf(EXIST, NONE, NONE, EXIST, NONE))
        ).forAll { (trial, result) ->
            answer.match(trial).values shouldBe result.values
        }
    }

})