package wordle

class Word(val value: String) {

    init {
        require(value.length == 5) {"단어는 5글자여야 합니다."}
    }
}