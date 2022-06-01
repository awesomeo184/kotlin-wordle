package wordle

import java.io.File

class WordPool {

    private val pool = mutableSetOf<String>()

    init {
        File("src/main/resources/words.txt").useLines {
                lines -> lines.forEach { pool.add(it) }
        }
    }

    fun isExist(input: String): Boolean {
        return pool.contains(input)
    }
}