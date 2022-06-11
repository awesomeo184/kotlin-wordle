package wordle

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import wordle.domain.Word

class WordTest : StringSpec({

    "단어는 5글자여야 한다" {
        listOf(
            "",
            "a",
            "at",
            "app",
            "pobi",
            "browns"
        ).forAll { value -> shouldThrow<IllegalArgumentException> { Word(value) } }
    }

    "wordCount" {
        Word("aabbc").wordCounter() shouldBe mapOf(Pair('a', 2), Pair('b', 2), Pair('c', 1))
    }
})