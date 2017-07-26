package owide.language

interface Lexer {

    fun reset()
    fun nexToken(): Token

}