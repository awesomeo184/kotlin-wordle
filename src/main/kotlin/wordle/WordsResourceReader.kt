package wordle

import java.io.File

class WordsResourceReader {

    fun readWords(path: String): Set<String> {
        return File(path).useLines { it.toSet() }
    }
}