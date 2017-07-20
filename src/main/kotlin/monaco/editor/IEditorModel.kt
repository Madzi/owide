package monaco.editor

external interface IEditorModel {
    fun onDidChangeContent()
    fun onDidChangeDecorations()
    fun onDidChangeLanguage()
    fun onDidChangeOptions()
    fun onWillDispose()

    val id: Any
    val uri: Any

    fun getValue(eol: Any = definedExternally, preservedBOM: Boolean = definedExternally): String // EndOfLinePreference
}