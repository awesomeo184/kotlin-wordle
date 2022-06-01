package wordle

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class WordPoolTest : ShouldSpec({

    should("return the result of search") {
        WordPool().isExist("abcde") shouldBe false
        WordPool().isExist("judge") shouldBe true
    }
})