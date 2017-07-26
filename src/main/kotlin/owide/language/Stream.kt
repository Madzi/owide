package owide.language

class Stream(val text: String) {

    private var pos = 0

    fun reset() { pos = 0 }
    fun eof(): Boolean = pos >= text.length
    fun next(): Char = text[pos++]
    fun nextWord(): String = TODO("Not implemented yet")

}