package wordle

import java.io.File

class WordsResourceReader {

    fun readWords(path: String): Set<Word> {
        return File(path).useLines { it -> it.map { Word(it) }.toSet() }
    }
}