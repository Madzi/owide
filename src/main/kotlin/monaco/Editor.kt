package monaco

import monaco.editor.IModel
import org.w3c.dom.HTMLElement
import kotlin.js.Promise

external interface Editor {
    var EditorType: Any

    fun colorize(text: String, languageId: String, options: Any): Promise<String> //IColorizerOptions
    fun colorizeElement(domNode: HTMLElement, options: Any): Promise<Unit> // IColorizerElementOptions
    fun colorizeModelLine(model: IModel, lineNumber: Number, tabSize: Number = definedExternally): String
    fun create(domElement: HTMLElement, options: Any = definedExternally, override: Any = definedExternally): Any // IEditorConstructionOptions IEditorOverrideServices IStandaloneCodeEditor
    fun createDiffEditor(domElement: HTMLElement, options: Any = definedExternally, override: Any): Any // IDiffEditorConstructionOptions IEditorOverrideServices IStandardDiffEditor
    fun createDiffNavigator(diffEditor: Any, opts: Any = definedExternally): Any // ISandaloneDiffEditor IDiffNavigatorOptions IDiffNavigator
    fun createModel(value: String, language: String = definedExternally, uri: Any = definedExternally): IModel // Uri
    fun createWebWorker(opts: Any): Any
    fun defineTheme(themeName: String, themeData: Any) // IStandaloneThemeData
    fun getModel(uri: Any): IModel // Uri
    fun getModels(): Array<IModel>
    fun setModelLanguage(model: IModel, language: String)
    fun setModelMarkers(model: IModel, owner: String, markers: Array<Any>) // IMarkerData
    fun setTheme(themeName: String)
    fun tokenize(text: String, languageId: String): Array<Any> // Token

    fun onDidChangeModelLanguage(listener: () -> Unit): IDisposable
}