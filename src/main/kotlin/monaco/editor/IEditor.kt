package monaco.editor

import monaco.IDisposable

external interface IEditor {
    fun onDidDispose(listener: () -> Unit): IDisposable

    fun dispose()
    fun focus()
    fun getActions(): Any // IEditorAction[]
    fun getEditorType(): String
    fun getId(): String
    fun getModel(): IEditorModel
    fun getPosition(): Any // Position
    fun getSelection(): Any // Selection
    fun getSelections(): Any // Selection[]
    fun getSupportedActions(): Any // IEditorAction[]
    fun getVisibleColumnFromPosition(position: Any): Number // IPosition
    fun isFocused(): Boolean
    fun layout(dimension: Any = definedExternally) // IDimension
    fun restoreViewState(state: Any) // IEditorViewState
    fun revealLine(lineNumber: Number)
    fun revealLineInCenter(lineNumber: Number)
    fun revealLineInCenterIfOutsideViewport(lineNumber: Number)
    fun revealLines(startLineNumber: Number, endLineNumber: Number)
    fun revealLinesInCenter(startLineNumber: Number, endLineNumber: Number)
    fun revealLinesInCenterIfOutsideViewport(startLineNumber: Number, endLineNumber: Number)
    fun revealPosition(position: Any, revealVerticalCenter: Boolean = definedExternally, revealHorizontal: Boolean = definedExternally) // IPosition
    fun revealPositionInCenter(position: Any) // IPosition
    fun revealPositionInCenterIfOutsideViewport(position: Any) // IPosition
    fun revealRange(range: Any) // IRange
    fun revealRangeAtTop(range: Any) // IRange
    fun revealRangeInCenter(range: Any) // IRange
    fun revealRangeInCenterIfOutsideViewport(range: Any) // IRange
    fun saveViewState(): Any // IEditorViewState
    fun setModel(model: IEditorModel)
    fun setPosition(position: Any) // IPosition
    fun setSelection(selection: Any) // IRAnge, Range, ISelection, Selection
    fun setSelections(selections: Any) // ISelection[]
    fun trigger(source: String, handlerId: String, payload: Any)
    fun updateOptions(newOptions: Any) //IEditorOptions
}