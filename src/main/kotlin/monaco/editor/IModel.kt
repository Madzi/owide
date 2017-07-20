package monaco.editor

external interface IModel : IEditorModel {
    fun onDidChangeContent()
    fun onDidChangeDecorations()
    fun onDidChangeLanguage()
    fun onDidChangeOptions()
    fun onWillDispose()

    val id: Any
    val uri: Any
}