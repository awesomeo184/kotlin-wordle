package wordle

import java.io.File

class WordsResourceReader {

    fun readWords(path: String): List<Word> {
        return File(path).useLines { it -> it.map { Word(it) }.toList() }
    }
}