package wordle

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class WordsResourceReaderTest : AnnotationSpec() {

    @Test
    fun `경로의 파일에서 단어를 읽어온다`() {
        val reader = WordsResourceReader()
        val words = reader.readWords("src/main/resources/words.txt")
        words.size shouldBe 2309
    }
}