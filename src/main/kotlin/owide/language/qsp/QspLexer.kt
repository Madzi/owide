package owide.language.qsp

import owide.language.Lexer
import owide.language.Stream
import owide.language.Token

enum class QspScope {
    ANNOTATION,
    NONE
}

class QspLexer(val stream: Stream) : Lexer {

    var scope: QspScope = QspScope.NONE

    override fun reset() {
        stream.reset()
        scope = QspScope.NONE
    }

    override fun nexToken(): Token {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun annotation(): Token {
        scope = QspScope.ANNOTATION
        return QspAnnotationToken(stream.nextWord())
    }

}