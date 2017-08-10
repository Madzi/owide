@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.editor")
package monaco.editor

import monaco.*
import monaco.languages.json.T16
import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.Range
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import kotlin.js.Promise

external fun create(domElement: HTMLElement, options: IEditorConstructionOptions? = definedExternally /* null */, override: IEditorOverrideServices? = definedExternally /* null */): IStandaloneCodeEditor = definedExternally
external fun onDidCreateEditor(listener: (codeEditor: ICodeEditor) -> Unit): IDisposable = definedExternally
external fun createDiffEditor(domElement: HTMLElement, options: IDiffEditorConstructionOptions? = definedExternally /* null */, override: IEditorOverrideServices? = definedExternally /* null */): IStandaloneDiffEditor = definedExternally
external interface IDiffNavigator {
    var revealFirst: Boolean
    fun canNavigate(): Boolean
    fun next()
    fun previous()
    fun dispose()
}
external interface IDiffNavigatorOptions {
    var followsCaret: Boolean? get() = definedExternally; set(value) = definedExternally
    var ignoreCharChanges: Boolean? get() = definedExternally; set(value) = definedExternally
    var alwaysRevealFirst: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun createDiffNavigator(diffEditor: IStandaloneDiffEditor, opts: IDiffNavigatorOptions? = definedExternally /* null */): IDiffNavigator = definedExternally
external fun createModel(value: String, language: String? = definedExternally /* null */, uri: Uri? = definedExternally /* null */): IModel = definedExternally
external fun setModelLanguage(model: IModel, language: String): Unit = definedExternally
external fun setModelMarkers(model: IModel, owner: String, markers: Array<IMarkerData>): Unit = definedExternally
external fun getModel(uri: Uri): IModel = definedExternally
external fun getModels(): Array<IModel> = definedExternally
external fun onDidCreateModel(listener: (model: IModel) -> Unit): IDisposable = definedExternally
external fun onWillDisposeModel(listener: (model: IModel) -> Unit): IDisposable = definedExternally
external interface `T$6` {
    var model: IModel
    var oldLanguage: String
}
external fun onDidChangeModelLanguage(listener: (e: Any) -> Unit): IDisposable = definedExternally
external fun <T> createWebWorker(opts: IWebWorkerOptions): MonacoWebWorker<T> = definedExternally
external fun colorizeElement(domNode: HTMLElement, options: IColorizerElementOptions): Promise<Unit> = definedExternally
external fun colorize(text: String, languageId: String, options: IColorizerOptions): Promise<String> = definedExternally
external fun colorizeModelLine(model: IModel, lineNumber: Number, tabSize: Number? = definedExternally /* null */): String = definedExternally
external fun tokenize(text: String, languageId: String): Array<Array<Token>> = definedExternally
external fun defineTheme(themeName: String, themeData: IStandaloneThemeData): Unit = definedExternally
external fun setTheme(themeName: String): Unit = definedExternally
external interface IStandaloneThemeData {
    var base: dynamic /* Any /* "vs" */ | Any /* "vs-dark" */ | Any /* "hc-black" */ */
    var inherit: Boolean
    var rules: Array<ITokenThemeRule>
    var colors: IColors
}
external interface IColors {
    @nativeGetter
    operator fun get(colorId: String): String?
    @nativeSetter
    operator fun set(colorId: String, value: String)
}
external interface ITokenThemeRule {
    var token: String
    var foreground: String? get() = definedExternally; set(value) = definedExternally
    var background: String? get() = definedExternally; set(value) = definedExternally
    var fontStyle: String? get() = definedExternally; set(value) = definedExternally
}
external interface MonacoWebWorker<T> {
    fun dispose()
    fun getProxy(): Promise<T>
    fun withSyncedResources(resources: Array<Uri>): Promise<T>
}
external interface IWebWorkerOptions {
    var moduleId: String
    var createData: Any? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
}
external interface IEditorConstructionOptions : IEditorOptions {
    var model: IModel? get() = definedExternally; set(value) = definedExternally
    var value: String? get() = definedExternally; set(value) = definedExternally
    var language: String? get() = definedExternally; set(value) = definedExternally
    var theme: String? get() = definedExternally; set(value) = definedExternally
    var accessibilityHelpUrl: String? get() = definedExternally; set(value) = definedExternally
}
external interface IDiffEditorConstructionOptions : IDiffEditorOptions {
    var theme: String? get() = definedExternally; set(value) = definedExternally
}
external interface IStandaloneCodeEditor : ICodeEditor {
    fun addCommand(keybinding: Number, handler: ICommandHandler, context: String): String
    fun <T> createContextKey(key: String, defaultValue: T): IContextKey<T>
    fun addAction(descriptor: IActionDescriptor): IDisposable
}
external interface IStandaloneDiffEditor : IDiffEditor {
    fun addCommand(keybinding: Number, handler: ICommandHandler, context: String): String
    fun <T> createContextKey(key: String, defaultValue: T): IContextKey<T>
    fun addAction(descriptor: IActionDescriptor): IDisposable
    override fun getOriginalEditor(): IStandaloneCodeEditor
    override fun getModifiedEditor(): IStandaloneCodeEditor
}
external interface ICommandHandler {
    @nativeInvoke
    operator fun invoke(vararg args: Any)
}
external interface IContextKey<T> {
    fun set(value: T)
    fun reset()
    fun get(): T
}
external interface IEditorOverrideServices {
    @nativeGetter
    operator fun get(index: String): Any?
    @nativeSetter
    operator fun set(index: String, value: Any)
}
external interface IMarkerData {
    var code: String? get() = definedExternally; set(value) = definedExternally
    var severity: Severity
    var message: String
    var source: String? get() = definedExternally; set(value) = definedExternally
    var startLineNumber: Number
    var startColumn: Number
    var endLineNumber: Number
    var endColumn: Number
}
external interface IColorizerOptions {
    var tabSize: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IColorizerElementOptions : IColorizerOptions {
    var theme: String? get() = definedExternally; set(value) = definedExternally
    var mimeType: String? get() = definedExternally; set(value) = definedExternally
}
external enum class ScrollbarVisibility {
    Auto /* = 1 */,
    Hidden /* = 2 */,
    Visible /* = 3 */
}
external interface ThemeColor {
    var id: String
}
external enum class OverviewRulerLane {
    Left /* = 1 */,
    Center /* = 2 */,
    Right /* = 4 */,
    Full /* = 7 */
}
external interface IModelDecorationOverviewRulerOptions {
    var color: dynamic /* String | ThemeColor */
    var darkColor: dynamic /* String | ThemeColor */
    var hcColor: dynamic /* String | ThemeColor */ get() = definedExternally; set(value) = definedExternally
    var position: OverviewRulerLane
}
external interface IModelDecorationOptions {
    var stickiness: TrackedRangeStickiness? get() = definedExternally; set(value) = definedExternally
    var className: String? get() = definedExternally; set(value) = definedExternally
    var glyphMarginHoverMessage: dynamic /* MarkedString | Array<MarkedString> */ get() = definedExternally; set(value) = definedExternally
    var hoverMessage: dynamic /* MarkedString | Array<MarkedString> */ get() = definedExternally; set(value) = definedExternally
    var isWholeLine: Boolean? get() = definedExternally; set(value) = definedExternally
    var overviewRuler: IModelDecorationOverviewRulerOptions? get() = definedExternally; set(value) = definedExternally
    var glyphMarginClassName: String? get() = definedExternally; set(value) = definedExternally
    var linesDecorationsClassName: String? get() = definedExternally; set(value) = definedExternally
    var marginClassName: String? get() = definedExternally; set(value) = definedExternally
    var inlineClassName: String? get() = definedExternally; set(value) = definedExternally
    var beforeContentClassName: String? get() = definedExternally; set(value) = definedExternally
    var afterContentClassName: String? get() = definedExternally; set(value) = definedExternally
}
external interface IModelDeltaDecoration {
    var range: IRange
    var options: IModelDecorationOptions
}
external interface IModelDecoration {
    var id: String
    var ownerId: Number
    var range: Range
    var options: IModelDecorationOptions
    var isForValidation: Boolean
}
external interface IWordAtPosition {
    var word: String
    var startColumn: Number
    var endColumn: Number
}
external enum class EndOfLinePreference {
    TextDefined /* = 0 */,
    LF /* = 1 */,
    CRLF /* = 2 */
}
external enum class DefaultEndOfLine {
    LF /* = 1 */,
    CRLF /* = 2 */
}
external enum class EndOfLineSequence {
    LF /* = 0 */,
    CRLF /* = 1 */
}
external interface ISingleEditOperationIdentifier {
    var major: Number
    var minor: Number
}
external interface IEditOperationBuilder {
    fun addEditOperation(range: Range, text: String)
    fun addTrackedEditOperation(range: Range, text: String)
    fun trackSelection(selection: Selection, trackPreviousOnEmpty: Boolean? = definedExternally /* null */): String
}
external interface ICursorStateComputerData {
    fun getInverseEditOperations(): Array<IIdentifiedSingleEditOperation>
    fun getTrackedSelection(id: String): Selection
}
external interface ICommand {
    fun getEditOperations(model: ITokenizedModel, builder: IEditOperationBuilder)
    fun computeCursorState(model: ITokenizedModel, helper: ICursorStateComputerData): Selection
}
external interface ISingleEditOperation {
    var range: IRange
    var text: String
    var forceMoveMarkers: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface IIdentifiedSingleEditOperation {
    var identifier: ISingleEditOperationIdentifier
    var range: Range
    var text: String
    var forceMoveMarkers: Boolean
    var isAutoWhitespaceEdit: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface ICursorStateComputer {
    @nativeInvoke
    operator fun invoke(inverseEditOperations: Array<IIdentifiedSingleEditOperation>): Array<Selection>
}
external open class TextModelResolvedOptions {
    open var _textModelResolvedOptionsBrand: dynamic = definedExternally
    open var tabSize: Number = definedExternally
    open var insertSpaces: Boolean = definedExternally
    open var defaultEOL: DefaultEndOfLine = definedExternally
    open var trimAutoWhitespace: Boolean = definedExternally
}
external interface ITextModelUpdateOptions {
    var tabSize: Number? get() = definedExternally; set(value) = definedExternally
    var insertSpaces: Boolean? get() = definedExternally; set(value) = definedExternally
    var trimAutoWhitespace: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface ITextModel {
    fun getOptions(): TextModelResolvedOptions
    fun getVersionId(): Number
    fun getAlternativeVersionId(): Number
    fun setValue(newValue: String)
    fun getValue(eol: EndOfLinePreference? = definedExternally /* null */, preserveBOM: Boolean? = definedExternally /* null */): String
    fun getValueLength(eol: EndOfLinePreference? = definedExternally /* null */, preserveBOM: Boolean? = definedExternally /* null */): Number
    fun getValueInRange(range: IRange, eol: EndOfLinePreference? = definedExternally /* null */): String
    fun getValueLengthInRange(range: IRange): Number
    fun getLineCount(): Number
    fun getLineContent(lineNumber: Number): String
    fun getLinesContent(): Array<String>
    fun getEOL(): String
    fun setEOL(eol: EndOfLineSequence)
    fun getLineMinColumn(lineNumber: Number): Number
    fun getLineMaxColumn(lineNumber: Number): Number
    fun getLineFirstNonWhitespaceColumn(lineNumber: Number): Number
    fun getLineLastNonWhitespaceColumn(lineNumber: Number): Number
    fun validatePosition(position: IPosition): Position
    fun modifyPosition(position: IPosition, offset: Number): Position
    fun validateRange(range: IRange): Range
    fun getOffsetAt(position: IPosition): Number
    fun getPositionAt(offset: Number): Position
    fun getFullModelRange(): Range
    fun isDisposed(): Boolean
    fun findMatches(searchString: String, searchOnlyEditableRange: Boolean, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean, limitResultCount: Number? = definedExternally /* null */): Array<FindMatch>
    fun findMatches(searchString: String, searchScope: IRange, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean, limitResultCount: Number? = definedExternally /* null */): Array<FindMatch>
    fun findNextMatch(searchString: String, searchStart: IPosition, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean): FindMatch
    fun findPreviousMatch(searchString: String, searchStart: IPosition, isRegex: Boolean, matchCase: Boolean, wordSeparators: String, captureMatches: Boolean): FindMatch
}
external open class FindMatch {
    open var _findMatchBrand: dynamic = definedExternally
    open var range: Range = definedExternally
    open var matches: Array<String> = definedExternally
}
external interface IReadOnlyModel : ITextModel {
    var uri: Uri
    fun getModeId(): String
    fun getWordAtPosition(position: IPosition): IWordAtPosition
    fun getWordUntilPosition(position: IPosition): IWordAtPosition
}
external interface ITokenizedModel : ITextModel {
    fun getModeId(): String
    fun getWordAtPosition(position: IPosition): IWordAtPosition
    fun getWordUntilPosition(position: IPosition): IWordAtPosition
}
external interface ITextModelWithMarkers : ITextModel
external enum class TrackedRangeStickiness {
    AlwaysGrowsWhenTypingAtEdges /* = 0 */,
    NeverGrowsWhenTypingAtEdges /* = 1 */,
    GrowsOnlyWhenTypingBefore /* = 2 */,
    GrowsOnlyWhenTypingAfter /* = 3 */
}
external interface ITextModelWithDecorations {
    fun deltaDecorations(oldDecorations: Array<String>, newDecorations: Array<IModelDeltaDecoration>, ownerId: Number? = definedExternally /* null */): Array<String>
    fun getDecorationOptions(id: String): IModelDecorationOptions
    fun getDecorationRange(id: String): Range
    fun getLineDecorations(lineNumber: Number, ownerId: Number? = definedExternally /* null */, filterOutValidation: Boolean? = definedExternally /* null */): Array<IModelDecoration>
    fun getLinesDecorations(startLineNumber: Number, endLineNumber: Number, ownerId: Number? = definedExternally /* null */, filterOutValidation: Boolean? = definedExternally /* null */): Array<IModelDecoration>
    fun getDecorationsInRange(range: IRange, ownerId: Number? = definedExternally /* null */, filterOutValidation: Boolean? = definedExternally /* null */): Array<IModelDecoration>
    fun getAllDecorations(ownerId: Number? = definedExternally /* null */, filterOutValidation: Boolean? = definedExternally /* null */): Array<IModelDecoration>
}
external interface IEditableTextModel : ITextModelWithMarkers {
    fun normalizeIndentation(str: String): String
    fun getOneIndent(): String
    fun updateOptions(newOpts: ITextModelUpdateOptions)
    fun detectIndentation(defaultInsertSpaces: Boolean, defaultTabSize: Number)
    fun pushStackElement()
    fun pushEditOperations(beforeCursorState: Array<Selection>, editOperations: Array<IIdentifiedSingleEditOperation>, cursorStateComputer: ICursorStateComputer): Array<Selection>
    fun applyEdits(operations: Array<IIdentifiedSingleEditOperation>): Array<IIdentifiedSingleEditOperation>
}
external interface IModel : IReadOnlyModel, IEditableTextModel, ITextModelWithMarkers, ITokenizedModel, ITextModelWithDecorations {
    fun onDidChangeContent(listener: (e: IModelContentChangedEvent) -> Unit): IDisposable
    fun onDidChangeDecorations(listener: (e: IModelDecorationsChangedEvent) -> Unit): IDisposable
    fun onDidChangeOptions(listener: (e: IModelOptionsChangedEvent) -> Unit): IDisposable
    fun onDidChangeLanguage(listener: (e: IModelLanguageChangedEvent) -> Unit): IDisposable
    fun onWillDispose(listener: () -> Unit): IDisposable
    var id: String
    fun dispose()
}
external interface IDiffEditorModel {
    var original: IModel
    var modified: IModel
}
external interface IModelChangedEvent {
    var oldModelUrl: Uri
    var newModelUrl: Uri
}
external interface IDimension {
    var width: Number
    var height: Number
}
external interface IChange {
    var originalStartLineNumber: Number
    var originalEndLineNumber: Number
    var modifiedStartLineNumber: Number
    var modifiedEndLineNumber: Number
}
external interface ICharChange : IChange {
    var originalStartColumn: Number
    var originalEndColumn: Number
    var modifiedStartColumn: Number
    var modifiedEndColumn: Number
}
external interface ILineChange : IChange {
    var charChanges: Array<ICharChange>
}
external interface IDiffLineInformation {
    var equivalentLineNumber: Number
}
external interface INewScrollPosition {
    var scrollLeft: Number? get() = definedExternally; set(value) = definedExternally
    var scrollTop: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IActionDescriptor {
    var id: String
    var label: String
    var precondition: String? get() = definedExternally; set(value) = definedExternally
    var keybindings: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var keybindingContext: String? get() = definedExternally; set(value) = definedExternally
    var contextMenuGroupId: String? get() = definedExternally; set(value) = definedExternally
    var contextMenuOrder: Number? get() = definedExternally; set(value) = definedExternally
    fun run(editor: ICommonCodeEditor): dynamic /* Unit | Promise<Unit> */
}
external interface IEditorAction {
    var id: String
    var label: String
    var alias: String
    fun isSupported(): Boolean
    fun run(): Promise<Unit>
}
external interface ICursorState {
    var inSelectionMode: Boolean
    var selectionStart: IPosition
    var position: IPosition
}
external interface IViewState {
    var scrollTop: Number
    var scrollTopWithoutViewZones: Number
    var scrollLeft: Number
}
external interface ICodeEditorViewState {
    var cursorState: Array<ICursorState>
    var viewState: IViewState
    var contributionsState: Json
}
external interface IDiffEditorViewState {
    var original: ICodeEditorViewState
    var modified: ICodeEditorViewState
}
external interface IEditor {
    fun onDidDispose(listener: () -> Unit): IDisposable
    fun dispose()
    fun getId(): String
    fun getEditorType(): String
    fun updateOptions(newOptions: IEditorOptions)
    fun layout(dimension: IDimension? = definedExternally /* null */)
    fun focus()
    fun isFocused(): Boolean
    fun getActions(): Array<IEditorAction>
    fun getSupportedActions(): Array<IEditorAction>
    fun saveViewState(): dynamic /* ICodeEditorViewState | IDiffEditorViewState */
    fun restoreViewState(state: ICodeEditorViewState)
    fun restoreViewState(state: IDiffEditorViewState)
    fun getVisibleColumnFromPosition(position: IPosition): Number
    fun getPosition(): Position
    fun setPosition(position: IPosition)
    fun revealLine(lineNumber: Number)
    fun revealLineInCenter(lineNumber: Number)
    fun revealLineInCenterIfOutsideViewport(lineNumber: Number)
    fun revealPosition(position: IPosition, revealVerticalInCenter: Boolean? = definedExternally /* null */, revealHorizontal: Boolean? = definedExternally /* null */)
    fun revealPositionInCenter(position: IPosition)
    fun revealPositionInCenterIfOutsideViewport(position: IPosition)
    fun getSelection(): Selection
    fun getSelections(): Array<Selection>
    fun setSelection(selection: IRange)
    fun setSelection(selection: Range)
    fun setSelection(selection: ISelection)
    fun setSelection(selection: Selection)
    fun setSelections(selections: Array<ISelection>)
    fun revealLines(startLineNumber: Number, endLineNumber: Number)
    fun revealLinesInCenter(lineNumber: Number, endLineNumber: Number)
    fun revealLinesInCenterIfOutsideViewport(lineNumber: Number, endLineNumber: Number)
    fun revealRange(range: IRange)
    fun revealRangeInCenter(range: IRange)
    fun revealRangeAtTop(range: IRange)
    fun revealRangeInCenterIfOutsideViewport(range: IRange)
    fun trigger(source: String, handlerId: String, payload: Any)
    fun getModel(): dynamic /* IModel | IDiffEditorModel */
    fun setModel(model: IModel)
    fun setModel(model: IDiffEditorModel)
}
external interface IEditorContribution {
    fun getId(): String
    fun dispose()
    val saveViewState: (() -> Any)? get() = definedExternally
    val restoreViewState: ((state: Any) -> Unit)? get() = definedExternally
}
external interface `T$8` {
    var preserveBOM: Boolean
    var lineEnding: String
}
external interface ICommonCodeEditor : IEditor {
    fun onDidChangeModelContent(listener: (e: IModelContentChangedEvent) -> Unit): IDisposable
    fun onDidChangeModelLanguage(listener: (e: IModelLanguageChangedEvent) -> Unit): IDisposable
    fun onDidChangeModelOptions(listener: (e: IModelOptionsChangedEvent) -> Unit): IDisposable
    fun onDidChangeConfiguration(listener: (e: IConfigurationChangedEvent) -> Unit): IDisposable
    fun onDidChangeCursorPosition(listener: (e: ICursorPositionChangedEvent) -> Unit): IDisposable
    fun onDidChangeCursorSelection(listener: (e: ICursorSelectionChangedEvent) -> Unit): IDisposable
    fun onDidChangeModel(listener: (e: IModelChangedEvent) -> Unit): IDisposable
    fun onDidChangeModelDecorations(listener: (e: IModelDecorationsChangedEvent) -> Unit): IDisposable
    fun onDidFocusEditorText(listener: () -> Unit): IDisposable
    fun onDidBlurEditorText(listener: () -> Unit): IDisposable
    fun onDidFocusEditor(listener: () -> Unit): IDisposable
    fun onDidBlurEditor(listener: () -> Unit): IDisposable
    override fun saveViewState(): ICodeEditorViewState
    override fun restoreViewState(state: ICodeEditorViewState)
    fun hasWidgetFocus(): Boolean
    fun <T : IEditorContribution> getContribution(id: String): T
    override fun getModel(): IModel
    fun getConfiguration(): InternalEditorOptions
    fun getValue(options: `T$8`? = definedExternally /* null */): String
    fun setValue(newValue: String)
    fun getScrollWidth(): Number
    fun getScrollLeft(): Number
    fun getScrollHeight(): Number
    fun getScrollTop(): Number
    fun setScrollLeft(newScrollLeft: Number)
    fun setScrollTop(newScrollTop: Number)
    fun setScrollPosition(position: INewScrollPosition)
    fun getAction(id: String): IEditorAction
    fun executeCommand(source: String, command: ICommand)
    fun pushUndoStop(): Boolean
    fun executeEdits(source: String, edits: Array<IIdentifiedSingleEditOperation>, endCursoState: Array<Selection>? = definedExternally /* null */): Boolean
    fun executeCommands(source: String, commands: Array<ICommand>)
    fun getLineDecorations(lineNumber: Number): Array<IModelDecoration>
    fun deltaDecorations(oldDecorations: Array<String>, newDecorations: Array<IModelDeltaDecoration>): Array<String>
    fun getLayoutInfo(): EditorLayoutInfo
}
external interface `T$9` {
    var preserveBOM: Boolean
    var lineEnding: String
}
external interface ICommonDiffEditor : IEditor {
    fun onDidUpdateDiff(listener: () -> Unit): IDisposable
    override fun saveViewState(): IDiffEditorViewState
    override fun restoreViewState(state: IDiffEditorViewState)
    override fun getModel(): IDiffEditorModel
    fun getOriginalEditor(): ICommonCodeEditor
    fun getModifiedEditor(): ICommonCodeEditor
    fun getLineChanges(): Array<ILineChange>
    fun getDiffLineInformationForOriginal(lineNumber: Number): IDiffLineInformation
    fun getDiffLineInformationForModified(lineNumber: Number): IDiffLineInformation
    fun getValue(options: `T$9`? = definedExternally /* null */): String
}
external interface `T$10` {
    var ICodeEditor: String
    var IDiffEditor: String
}
external var EditorType: `T$10` = definedExternally
external interface IModelLanguageChangedEvent {
    var oldLanguage: String
    var newLanguage: String
}
external interface IModelContentChange {
    var range: IRange
    var rangeLength: Number
    var text: String
}
external interface IModelContentChangedEvent {
    var changes: Array<IModelContentChange>
    var eol: String
    var versionId: Number
    var isUndoing: Boolean
    var isRedoing: Boolean
    var isFlush: Boolean
}
external interface IModelDecorationsChangedEvent {
    var addedDecorations: Array<String>
    var changedDecorations: Array<String>
    var removedDecorations: Array<String>
}
external interface `T$11` {
    var fromLineNumber: Number
    var toLineNumber: Number
}
external interface IModelTokensChangedEvent {
    var ranges: Array<`T$11`>
}
external interface IModelOptionsChangedEvent {
    var tabSize: Boolean
    var insertSpaces: Boolean
    var trimAutoWhitespace: Boolean
}
external enum class CursorChangeReason {
    NotSet /* = 0 */,
    ContentFlush /* = 1 */,
    RecoverFromMarkers /* = 2 */,
    Explicit /* = 3 */,
    Paste /* = 4 */,
    Undo /* = 5 */,
    Redo /* = 6 */
}
external interface ICursorPositionChangedEvent {
    var position: Position
    var secondaryPositions: Array<Position>
    var reason: CursorChangeReason
    var source: String
}
external interface ICursorSelectionChangedEvent {
    var selection: Selection
    var secondarySelections: Array<Selection>
    var source: String
    var reason: CursorChangeReason
}
external interface IEditorScrollbarOptions {
    var arrowSize: Number? get() = definedExternally; set(value) = definedExternally
    var vertical: String? get() = definedExternally; set(value) = definedExternally
    var horizontal: String? get() = definedExternally; set(value) = definedExternally
    var useShadows: Boolean? get() = definedExternally; set(value) = definedExternally
    var verticalHasArrows: Boolean? get() = definedExternally; set(value) = definedExternally
    var horizontalHasArrows: Boolean? get() = definedExternally; set(value) = definedExternally
    var handleMouseWheel: Boolean? get() = definedExternally; set(value) = definedExternally
    var horizontalScrollbarSize: Number? get() = definedExternally; set(value) = definedExternally
    var verticalScrollbarSize: Number? get() = definedExternally; set(value) = definedExternally
    var verticalSliderSize: Number? get() = definedExternally; set(value) = definedExternally
    var horizontalSliderSize: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IEditorFindOptions {
    var seedSearchStringFromSelection: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoFindInSelection: Boolean
}
external interface IEditorMinimapOptions {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var showSlider: dynamic /* Any /* "always" */ | Any /* "mouseover" */ */ get() = definedExternally; set(value) = definedExternally
    var renderCharacters: Boolean? get() = definedExternally; set(value) = definedExternally
    var maxColumn: Number? get() = definedExternally; set(value) = definedExternally
}
external interface `T$12` {
    var other: Boolean
    var comments: Boolean
    var strings: Boolean
}
external interface IEditorOptions {
    var ariaLabel: String? get() = definedExternally; set(value) = definedExternally
    var rulers: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var wordSeparators: String? get() = definedExternally; set(value) = definedExternally
    var selectionClipboard: Boolean? get() = definedExternally; set(value) = definedExternally
    var lineNumbers: dynamic /* Any /* "on" */ | Any /* "off" */ | Any /* "relative" */ | (lineNumber: Number) -> String */ get() = definedExternally; set(value) = definedExternally
    var selectOnLineNumbers: Boolean? get() = definedExternally; set(value) = definedExternally
    var lineNumbersMinChars: Number? get() = definedExternally; set(value) = definedExternally
    var glyphMargin: Boolean? get() = definedExternally; set(value) = definedExternally
    var lineDecorationsWidth: dynamic /* Number | String */ get() = definedExternally; set(value) = definedExternally
    var revealHorizontalRightPadding: Number? get() = definedExternally; set(value) = definedExternally
    var roundedSelection: Boolean? get() = definedExternally; set(value) = definedExternally
    var extraEditorClassName: String? get() = definedExternally; set(value) = definedExternally
    var readOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var scrollbar: IEditorScrollbarOptions? get() = definedExternally; set(value) = definedExternally
    var minimap: IEditorMinimapOptions? get() = definedExternally; set(value) = definedExternally
    var find: IEditorFindOptions? get() = definedExternally; set(value) = definedExternally
    var fixedOverflowWidgets: Boolean? get() = definedExternally; set(value) = definedExternally
    var overviewRulerLanes: Number? get() = definedExternally; set(value) = definedExternally
    var overviewRulerBorder: Boolean? get() = definedExternally; set(value) = definedExternally
    var cursorBlinking: String? get() = definedExternally; set(value) = definedExternally
    var mouseWheelZoom: Boolean? get() = definedExternally; set(value) = definedExternally
    var cursorStyle: String? get() = definedExternally; set(value) = definedExternally
    var fontLigatures: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableLayerHinting: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableMonospaceOptimizations: Boolean? get() = definedExternally; set(value) = definedExternally
    var hideCursorInOverviewRuler: Boolean? get() = definedExternally; set(value) = definedExternally
    var scrollBeyondLastLine: Boolean? get() = definedExternally; set(value) = definedExternally
    var automaticLayout: Boolean? get() = definedExternally; set(value) = definedExternally
    var wordWrap: dynamic /* Any /* "off" */ | Any /* "on" */ | Any /* "wordWrapColumn" */ | Any /* "bounded" */ */ get() = definedExternally; set(value) = definedExternally
    var wordWrapColumn: Number? get() = definedExternally; set(value) = definedExternally
    var wordWrapMinified: Boolean? get() = definedExternally; set(value) = definedExternally
    var wrappingIndent: String? get() = definedExternally; set(value) = definedExternally
    var wordWrapBreakBeforeCharacters: String? get() = definedExternally; set(value) = definedExternally
    var wordWrapBreakAfterCharacters: String? get() = definedExternally; set(value) = definedExternally
    var wordWrapBreakObtrusiveCharacters: String? get() = definedExternally; set(value) = definedExternally
    var stopRenderingLineAfter: Number? get() = definedExternally; set(value) = definedExternally
    var hover: Boolean? get() = definedExternally; set(value) = definedExternally
    var links: Boolean? get() = definedExternally; set(value) = definedExternally
    var contextmenu: Boolean? get() = definedExternally; set(value) = definedExternally
    var mouseWheelScrollSensitivity: Number? get() = definedExternally; set(value) = definedExternally
    var multiCursorModifier: dynamic /* Any /* "ctrlCmd" */ | Any /* "alt" */ */ get() = definedExternally; set(value) = definedExternally
    var accessibilitySupport: dynamic /* Any /* "auto" */ | Any /* "off" */ | Any /* "on" */ */ get() = definedExternally; set(value) = definedExternally
    var quickSuggestions: dynamic /* Boolean | `T$12` */ get() = definedExternally; set(value) = definedExternally
    var quickSuggestionsDelay: Number? get() = definedExternally; set(value) = definedExternally
    var parameterHints: Boolean? get() = definedExternally; set(value) = definedExternally
    var iconsInSuggestions: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoClosingBrackets: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoIndent: Boolean? get() = definedExternally; set(value) = definedExternally
    var formatOnType: Boolean? get() = definedExternally; set(value) = definedExternally
    var formatOnPaste: Boolean? get() = definedExternally; set(value) = definedExternally
    var dragAndDrop: Boolean? get() = definedExternally; set(value) = definedExternally
    var suggestOnTriggerCharacters: Boolean? get() = definedExternally; set(value) = definedExternally
    var acceptSuggestionOnEnter: dynamic /* Any /* "on" */ | Any /* "smart" */ | Any /* "off" */ */ get() = definedExternally; set(value) = definedExternally
    var acceptSuggestionOnCommitCharacter: Boolean? get() = definedExternally; set(value) = definedExternally
    var snippetSuggestions: dynamic /* Any /* "top" */ | Any /* "bottom" */ | Any /* "inline" */ | Any /* "none" */ */ get() = definedExternally; set(value) = definedExternally
    var emptySelectionClipboard: Boolean? get() = definedExternally; set(value) = definedExternally
    var wordBasedSuggestions: Boolean? get() = definedExternally; set(value) = definedExternally
    var suggestFontSize: Number? get() = definedExternally; set(value) = definedExternally
    var suggestLineHeight: Number? get() = definedExternally; set(value) = definedExternally
    var selectionHighlight: Boolean? get() = definedExternally; set(value) = definedExternally
    var occurrencesHighlight: Boolean? get() = definedExternally; set(value) = definedExternally
    var codeLens: Boolean? get() = definedExternally; set(value) = definedExternally
    var folding: Boolean? get() = definedExternally; set(value) = definedExternally
    var showFoldingControls: dynamic /* Any /* "always" */ | Any /* "mouseover" */ */ get() = definedExternally; set(value) = definedExternally
    var matchBrackets: Boolean? get() = definedExternally; set(value) = definedExternally
    var renderWhitespace: dynamic /* Any /* "none" */ | Any /* "boundary" */ | Any /* "all" */ */ get() = definedExternally; set(value) = definedExternally
    var renderControlCharacters: Boolean? get() = definedExternally; set(value) = definedExternally
    var renderIndentGuides: Boolean? get() = definedExternally; set(value) = definedExternally
    var renderLineHighlight: dynamic /* Any /* "none" */ | Any /* "gutter" */ | Any /* "line" */ | Any /* "all" */ */ get() = definedExternally; set(value) = definedExternally
    var useTabStops: Boolean? get() = definedExternally; set(value) = definedExternally
    var fontFamily: String? get() = definedExternally; set(value) = definedExternally
    var fontWeight: dynamic /* Any /* "normal" */ | Any /* "bold" */ | Any /* "bolder" */ | Any /* "lighter" */ | Any /* "initial" */ | Any /* "inherit" */ | Any /* "100" */ | Any /* "200" */ | Any /* "300" */ | Any /* "400" */ | Any /* "500" */ | Any /* "600" */ | Any /* "700" */ | Any /* "800" */ | Any /* "900" */ */ get() = definedExternally; set(value) = definedExternally
    var fontSize: Number? get() = definedExternally; set(value) = definedExternally
    var lineHeight: Number? get() = definedExternally; set(value) = definedExternally
    var letterSpacing: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IDiffEditorOptions : IEditorOptions {
    var enableSplitViewResizing: Boolean? get() = definedExternally; set(value) = definedExternally
    var renderSideBySide: Boolean? get() = definedExternally; set(value) = definedExternally
    var ignoreTrimWhitespace: Boolean? get() = definedExternally; set(value) = definedExternally
    var renderIndicators: Boolean? get() = definedExternally; set(value) = definedExternally
    var originalEditable: Boolean? get() = definedExternally; set(value) = definedExternally
}
external enum class RenderMinimap {
    None /* = 0 */,
    Small /* = 1 */,
    Large /* = 2 */,
    SmallBlocks /* = 3 */,
    LargeBlocks /* = 4 */
}
external enum class WrappingIndent {
    None /* = 0 */,
    Same /* = 1 */,
    Indent /* = 2 */
}
external enum class TextEditorCursorBlinkingStyle {
    Hidden /* = 0 */,
    Blink /* = 1 */,
    Smooth /* = 2 */,
    Phase /* = 3 */,
    Expand /* = 4 */,
    Solid /* = 5 */
}
external enum class TextEditorCursorStyle {
    Line /* = 1 */,
    Block /* = 2 */,
    Underline /* = 3 */,
    LineThin /* = 4 */,
    BlockOutline /* = 5 */,
    UnderlineThin /* = 6 */
}
external interface InternalEditorScrollbarOptions {
    var arrowSize: Number
    var vertical: ScrollbarVisibility
    var horizontal: ScrollbarVisibility
    var useShadows: Boolean
    var verticalHasArrows: Boolean
    var horizontalHasArrows: Boolean
    var handleMouseWheel: Boolean
    var horizontalScrollbarSize: Number
    var horizontalSliderSize: Number
    var verticalScrollbarSize: Number
    var verticalSliderSize: Number
    var mouseWheelScrollSensitivity: Number
}
external interface InternalEditorMinimapOptions {
    var enabled: Boolean
    var showSlider: dynamic /* Any /* "always" */ | Any /* "mouseover" */ */
    var renderCharacters: Boolean
    var maxColumn: Number
}
external interface InternalEditorFindOptions {
    var seedSearchStringFromSelection: Boolean
    var autoFindInSelection: Boolean
}
external interface EditorWrappingInfo {
    var inDiffEditor: Boolean
    var isDominatedByLongLines: Boolean
    var isWordWrapMinified: Boolean
    var isViewportWrapping: Boolean
    var wrappingColumn: Number
    var wrappingIndent: WrappingIndent
    var wordWrapBreakBeforeCharacters: String
    var wordWrapBreakAfterCharacters: String
    var wordWrapBreakObtrusiveCharacters: String
}
external interface InternalEditorViewOptions {
    var extraEditorClassName: String
    var disableMonospaceOptimizations: Boolean
    var rulers: Array<Number>
    var ariaLabel: String
    var renderLineNumbers: Boolean
    var renderCustomLineNumbers: (lineNumber: Number) -> String
    var renderRelativeLineNumbers: Boolean
    var selectOnLineNumbers: Boolean
    var glyphMargin: Boolean
    var revealHorizontalRightPadding: Number
    var roundedSelection: Boolean
    var overviewRulerLanes: Number
    var overviewRulerBorder: Boolean
    var cursorBlinking: TextEditorCursorBlinkingStyle
    var mouseWheelZoom: Boolean
    var cursorStyle: TextEditorCursorStyle
    var hideCursorInOverviewRuler: Boolean
    var scrollBeyondLastLine: Boolean
    var stopRenderingLineAfter: Number
    var renderWhitespace: dynamic /* Any /* "none" */ | Any /* "boundary" */ | Any /* "all" */ */
    var renderControlCharacters: Boolean
    var fontLigatures: Boolean
    var renderIndentGuides: Boolean
    var renderLineHighlight: dynamic /* Any /* "none" */ | Any /* "gutter" */ | Any /* "line" */ | Any /* "all" */ */
    var scrollbar: InternalEditorScrollbarOptions
    var minimap: InternalEditorMinimapOptions
    var fixedOverflowWidgets: Boolean
}
external interface EditorContribOptions {
    var selectionClipboard: Boolean
    var hover: Boolean
    var links: Boolean
    var contextmenu: Boolean
    var quickSuggestions: dynamic /* Boolean | `T$12` */
    var quickSuggestionsDelay: Number
    var parameterHints: Boolean
    var iconsInSuggestions: Boolean
    var formatOnType: Boolean
    var formatOnPaste: Boolean
    var suggestOnTriggerCharacters: Boolean
    var acceptSuggestionOnEnter: dynamic /* Any /* "on" */ | Any /* "smart" */ | Any /* "off" */ */
    var acceptSuggestionOnCommitCharacter: Boolean
    var snippetSuggestions: dynamic /* Any /* "top" */ | Any /* "bottom" */ | Any /* "inline" */ | Any /* "none" */ */
    var wordBasedSuggestions: Boolean
    var suggestFontSize: Number
    var suggestLineHeight: Number
    var selectionHighlight: Boolean
    var occurrencesHighlight: Boolean
    var codeLens: Boolean
    var folding: Boolean
    var showFoldingControls: dynamic /* Any /* "always" */ | Any /* "mouseover" */ */
    var matchBrackets: Boolean
    var find: InternalEditorFindOptions
}
external open class InternalEditorOptions {
    open var _internalEditorOptionsBrand: dynamic = definedExternally
    open var canUseLayerHinting: Boolean = definedExternally
    open var pixelRatio: Number = definedExternally
    open var editorClassName: String = definedExternally
    open var lineHeight: Number = definedExternally
    open var readOnly: Boolean = definedExternally
    open var multiCursorModifier: dynamic /* Any /* "altKey" */ | Any /* "ctrlKey" */ | Any /* "metaKey" */ */ = definedExternally
    open var wordSeparators: String = definedExternally
    open var autoClosingBrackets: Boolean = definedExternally
    open var autoIndent: Boolean = definedExternally
    open var useTabStops: Boolean = definedExternally
    open var tabFocusMode: Boolean = definedExternally
    open var dragAndDrop: Boolean = definedExternally
    open var emptySelectionClipboard: Boolean = definedExternally
    open var layoutInfo: EditorLayoutInfo = definedExternally
    open var fontInfo: FontInfo = definedExternally
    open var viewInfo: InternalEditorViewOptions = definedExternally
    open var wrappingInfo: EditorWrappingInfo = definedExternally
    open var contribInfo: EditorContribOptions = definedExternally
}
external interface OverviewRulerPosition {
    var width: Number
    var height: Number
    var top: Number
    var right: Number
}
external interface EditorLayoutInfo {
    var width: Number
    var height: Number
    var glyphMarginLeft: Number
    var glyphMarginWidth: Number
    var glyphMarginHeight: Number
    var lineNumbersLeft: Number
    var lineNumbersWidth: Number
    var lineNumbersHeight: Number
    var decorationsLeft: Number
    var decorationsWidth: Number
    var decorationsHeight: Number
    var contentLeft: Number
    var contentWidth: Number
    var contentHeight: Number
    var minimapWidth: Number
    var renderMinimap: RenderMinimap
    var viewportColumn: Number
    var verticalScrollbarWidth: Number
    var horizontalScrollbarHeight: Number
    var overviewRuler: OverviewRulerPosition
}
external interface IConfigurationChangedEvent {
    var canUseLayerHinting: Boolean
    var pixelRatio: Boolean
    var editorClassName: Boolean
    var lineHeight: Boolean
    var readOnly: Boolean
    var accessibilitySupport: Boolean
    var multiCursorModifier: Boolean
    var wordSeparators: Boolean
    var autoClosingBrackets: Boolean
    var autoIndent: Boolean
    var useTabStops: Boolean
    var tabFocusMode: Boolean
    var dragAndDrop: Boolean
    var emptySelectionClipboard: Boolean
    var layoutInfo: Boolean
    var fontInfo: Boolean
    var viewInfo: Boolean
    var wrappingInfo: Boolean
    var contribInfo: Boolean
}
external interface IViewZone {
    var afterLineNumber: Number
    var afterColumn: Number? get() = definedExternally; set(value) = definedExternally
    var suppressMouseDown: Boolean? get() = definedExternally; set(value) = definedExternally
    var heightInLines: Number? get() = definedExternally; set(value) = definedExternally
    var heightInPx: Number? get() = definedExternally; set(value) = definedExternally
    var domNode: HTMLElement
    var marginDomNode: HTMLElement? get() = definedExternally; set(value) = definedExternally
    var onDomNodeTop: ((top: Number) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var onComputedHeight: ((height: Number) -> Unit)? get() = definedExternally; set(value) = definedExternally
}
external interface IViewZoneChangeAccessor {
    fun addZone(zone: IViewZone): Number
    fun removeZone(id: Number)
    fun layoutZone(id: Number)
}
external enum class ContentWidgetPositionPreference {
    EXACT /* = 0 */,
    ABOVE /* = 1 */,
    BELOW /* = 2 */
}
external interface IContentWidgetPosition {
    var position: IPosition
    var preference: Array<ContentWidgetPositionPreference>
}
external interface IContentWidget {
    var allowEditorOverflow: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressMouseDown: Boolean? get() = definedExternally; set(value) = definedExternally
    fun getId(): String
    fun getDomNode(): HTMLElement
    fun getPosition(): IContentWidgetPosition
}
external enum class OverlayWidgetPositionPreference {
    TOP_RIGHT_CORNER /* = 0 */,
    BOTTOM_RIGHT_CORNER /* = 1 */,
    TOP_CENTER /* = 2 */
}
external interface IOverlayWidgetPosition {
    var preference: OverlayWidgetPositionPreference
}
external interface IOverlayWidget {
    fun getId(): String
    fun getDomNode(): HTMLElement
    fun getPosition(): IOverlayWidgetPosition
}
external enum class MouseTargetType {
    UNKNOWN /* = 0 */,
    TEXTAREA /* = 1 */,
    GUTTER_GLYPH_MARGIN /* = 2 */,
    GUTTER_LINE_NUMBERS /* = 3 */,
    GUTTER_LINE_DECORATIONS /* = 4 */,
    GUTTER_VIEW_ZONE /* = 5 */,
    CONTENT_TEXT /* = 6 */,
    CONTENT_EMPTY /* = 7 */,
    CONTENT_VIEW_ZONE /* = 8 */,
    CONTENT_WIDGET /* = 9 */,
    OVERVIEW_RULER /* = 10 */,
    SCROLLBAR /* = 11 */,
    OVERLAY_WIDGET /* = 12 */,
    OUTSIDE_EDITOR /* = 13 */
}
external interface IMouseTarget {
    var element: Element
    var type: MouseTargetType
    var position: Position
    var mouseColumn: Number
    var range: Range
    var detail: Any
}
external interface IEditorMouseEvent {
    var event: IMouseEvent
    var target: IMouseTarget
}
external interface `T$13` {
    var top: Number
    var left: Number
    var height: Number
}
external interface ICodeEditor : ICommonCodeEditor {
    fun onMouseUp(listener: (e: IEditorMouseEvent) -> Unit): IDisposable
    fun onMouseDown(listener: (e: IEditorMouseEvent) -> Unit): IDisposable
    fun onContextMenu(listener: (e: IEditorMouseEvent) -> Unit): IDisposable
    fun onMouseMove(listener: (e: IEditorMouseEvent) -> Unit): IDisposable
    fun onMouseLeave(listener: (e: IEditorMouseEvent) -> Unit): IDisposable
    fun onKeyUp(listener: (e: IKeyboardEvent) -> Unit): IDisposable
    fun onKeyDown(listener: (e: IKeyboardEvent) -> Unit): IDisposable
    fun onDidLayoutChange(listener: (e: EditorLayoutInfo) -> Unit): IDisposable
    fun onDidScrollChange(listener: (e: IScrollEvent) -> Unit): IDisposable
    fun getDomNode(): HTMLElement
    fun addContentWidget(widget: IContentWidget)
    fun layoutContentWidget(widget: IContentWidget)
    fun removeContentWidget(widget: IContentWidget)
    fun addOverlayWidget(widget: IOverlayWidget)
    fun layoutOverlayWidget(widget: IOverlayWidget)
    fun removeOverlayWidget(widget: IOverlayWidget)
    fun changeViewZones(callback: (accessor: IViewZoneChangeAccessor) -> Unit)
    fun getCenteredRangeInViewport(): Range
    fun getOffsetForColumn(lineNumber: Number, column: Number): Number
    fun render()
    fun getTopForLineNumber(lineNumber: Number): Number
    fun getTopForPosition(lineNumber: Number, column: Number): Number
    fun getTargetAtClientPoint(clientX: Number, clientY: Number): IMouseTarget
    fun getScrolledVisiblePosition(position: IPosition): `T$13`
    fun applyFontInfo(target: HTMLElement)
}
external interface IDiffEditor : ICommonDiffEditor {
    fun getDomNode(): HTMLElement
}
external open class FontInfo : BareFontInfo {
    open var _editorStylingBrand: dynamic = definedExternally
    open var isTrusted: Boolean = definedExternally
    open var isMonospace: Boolean = definedExternally
    open var typicalHalfwidthCharacterWidth: Number = definedExternally
    open var typicalFullwidthCharacterWidth: Number = definedExternally
    open var spaceWidth: Number = definedExternally
    open var maxDigitWidth: Number = definedExternally
}
external open class BareFontInfo {
    open var _bareFontInfoBrand: dynamic = definedExternally
    open var zoomLevel: Number = definedExternally
    open var fontFamily: String = definedExternally
    open var fontWeight: String = definedExternally
    open var fontSize: Number = definedExternally
    open var lineHeight: Number = definedExternally
    open var letterSpacing: Number = definedExternally
}
