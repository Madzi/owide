package monaco.editor

external interface ITextModel {
    fun findMatches(searchString: String, searchOnlyEditableRange: Boolean, isRegex: Boolean, matchCase: Boolean, wordSeparatos: String, captureMatches: Boolean, limitResultCount: Number = definedExternally): Any // FindMatch[]
    fun findNextMatch(searchString: String, searchStart: Any, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean): Any // IPosition FindMatch
    fun findPreviousMatch(searchString: String, searchStart: Any, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean): Any // IPosition FindMatch
    fun getAlternativeVersionId(): Number
    fun getEOL(): String
    fun getFullModelRange(): Any // Range
    fun getLineContent(lineNumber: Number): String
    fun getLineCount(): Number
    fun getLineFirstNonWhitespaceColumn(lineNumber: Number): Number
    fun getLineLastNonWhitespaceColumn(lineNumber: Number): Number
    fun getLineMaxColumn(lineNumber: Number): Number
    fun getLineMinColumn(lineNumber: Number): Number
    fun getLinesContent(): Array<String>
    fun getOffsetAt(position: Any): Number // IPosition
    fun getOptions(): Any // TextModelResolvedOptions
    fun getPositionAt(offset: Number): Any // Position
    fun getValue(eol: Any = definedExternally, preserveBOM: Boolean = definedExternally): String // EndOfLinePreference
    fun getValueInRange(range: Any, eol: Any = definedExternally): String // IRange, EndOfLinePreference
    fun getValueLength(eol: Any = definedExternally, preserveBOM: Boolean = definedExternally): Number // EndOfLinePreference
    fun getValueLengthInRange(range: Any): Number // IRange
    fun getVersionId(): Number
    fun isDisposed(): Boolean
    fun modifyPosition(position: Any, offset: Number): Any // IPosition Position
    fun setEOL(eol: Any) // EndOfLineSequence
    fun setValue(newValue: String)
    fun validatePosition(position: Any): Any // IPosition Position
    fun validateRange(range: Any): Any // IRange Range
}