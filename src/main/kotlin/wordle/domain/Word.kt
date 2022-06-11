package wordle.domain

class Word(val value: String) {

    init {
        require(value.length == 5) {"단어는 5글자여야 합니다."}
    }

    fun wordCounter(): MutableMap<Char, Int> {
        return value.groupingBy { it }.eachCount().toMutableMap()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Word

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
