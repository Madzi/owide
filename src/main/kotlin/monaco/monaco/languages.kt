@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.languages")
package monaco.languages

import monaco.*
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

external fun register(language: ILanguageExtensionPoint): Unit = definedExternally
external fun getLanguages(): Array<ILanguageExtensionPoint> = definedExternally
external fun onLanguage(languageId: String, callback: () -> Unit): IDisposable = definedExternally
external fun setLanguageConfiguration(languageId: String, configuration: LanguageConfiguration): IDisposable = definedExternally
external interface IToken {
    var startIndex: Number
    var scopes: String
}
external interface ILineTokens {
    var tokens: Array<IToken>
    var endState: IState
}
external interface TokensProvider {
    fun getInitialState(): IState
    fun tokenize(line: String, state: IState): ILineTokens
}
external fun setTokensProvider(languageId: String, provider: TokensProvider): IDisposable = definedExternally
external fun setMonarchTokensProvider(languageId: String, languageDef: IMonarchLanguage): IDisposable = definedExternally
external fun registerReferenceProvider(languageId: String, provider: ReferenceProvider): IDisposable = definedExternally
external fun registerRenameProvider(languageId: String, provider: RenameProvider): IDisposable = definedExternally
external fun registerSignatureHelpProvider(languageId: String, provider: SignatureHelpProvider): IDisposable = definedExternally
external fun registerHoverProvider(languageId: String, provider: HoverProvider): IDisposable = definedExternally
external fun registerDocumentSymbolProvider(languageId: String, provider: DocumentSymbolProvider): IDisposable = definedExternally
external fun registerDocumentHighlightProvider(languageId: String, provider: DocumentHighlightProvider): IDisposable = definedExternally
external fun registerDefinitionProvider(languageId: String, provider: DefinitionProvider): IDisposable = definedExternally
external fun registerImplementationProvider(languageId: String, provider: ImplementationProvider): IDisposable = definedExternally
external fun registerTypeDefinitionProvider(languageId: String, provider: TypeDefinitionProvider): IDisposable = definedExternally
external fun registerCodeLensProvider(languageId: String, provider: CodeLensProvider): IDisposable = definedExternally
external fun registerCodeActionProvider(languageId: String, provider: CodeActionProvider): IDisposable = definedExternally
external fun registerDocumentFormattingEditProvider(languageId: String, provider: DocumentFormattingEditProvider): IDisposable = definedExternally
external fun registerDocumentRangeFormattingEditProvider(languageId: String, provider: DocumentRangeFormattingEditProvider): IDisposable = definedExternally
external fun registerOnTypeFormattingEditProvider(languageId: String, provider: OnTypeFormattingEditProvider): IDisposable = definedExternally
external fun registerLinkProvider(languageId: String, provider: LinkProvider): IDisposable = definedExternally
external fun registerCompletionItemProvider(languageId: String, provider: CompletionItemProvider): IDisposable = definedExternally
external interface CodeActionContext {
    var markers: Array<monaco.editor.IMarkerData>
}
external interface CodeActionProvider {
    fun provideCodeActions(model: monaco.editor.IReadOnlyModel, range: Range, context: CodeActionContext, token: CancellationToken): dynamic /* Array<CodeAction> | Thenable<Array<CodeAction>> */
}
external enum class CompletionItemKind {
    Text /* = 0 */,
    Method /* = 1 */,
    Function /* = 2 */,
    Constructor /* = 3 */,
    Field /* = 4 */,
    Variable /* = 5 */,
    Class /* = 6 */,
    Interface /* = 7 */,
    Module /* = 8 */,
    Property /* = 9 */,
    Unit /* = 10 */,
    Value /* = 11 */,
    Enum /* = 12 */,
    Keyword /* = 13 */,
    Snippet /* = 14 */,
    Color /* = 15 */,
    File /* = 16 */,
    Reference /* = 17 */,
    Folder /* = 18 */
}
external interface SnippetString {
    var value: String
}
external interface CompletionItem {
    var label: String
    var kind: CompletionItemKind
    var detail: String? get() = definedExternally; set(value) = definedExternally
    var documentation: String? get() = definedExternally; set(value) = definedExternally
    var sortText: String? get() = definedExternally; set(value) = definedExternally
    var filterText: String? get() = definedExternally; set(value) = definedExternally
    var insertText: dynamic /* String | SnippetString */ get() = definedExternally; set(value) = definedExternally
    var range: Range? get() = definedExternally; set(value) = definedExternally
    var textEdit: monaco.editor.ISingleEditOperation? get() = definedExternally; set(value) = definedExternally
}
external interface CompletionList {
    var isIncomplete: Boolean? get() = definedExternally; set(value) = definedExternally
    var items: Array<CompletionItem>
}
external interface CompletionItemProvider {
    var triggerCharacters: Array<String>? get() = definedExternally; set(value) = definedExternally
    fun provideCompletionItems(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Array<CompletionItem> | Thenable<Array<CompletionItem>> | CompletionList | Thenable<CompletionList> */
    val resolveCompletionItem: ((item: CompletionItem, token: CancellationToken) -> dynamic /* CompletionItem | Thenable<CompletionItem> */)? get() = definedExternally
}
external interface CommentRule {
    var lineComment: String? get() = definedExternally; set(value) = definedExternally
    var blockComment: CharacterPair? get() = definedExternally; set(value) = definedExternally
}
external interface LanguageConfiguration {
    var comments: CommentRule? get() = definedExternally; set(value) = definedExternally
    var brackets: Array<CharacterPair>? get() = definedExternally; set(value) = definedExternally
    var wordPattern: RegExp? get() = definedExternally; set(value) = definedExternally
    var indentationRules: IndentationRule? get() = definedExternally; set(value) = definedExternally
    var onEnterRules: Array<OnEnterRule>? get() = definedExternally; set(value) = definedExternally
    var autoClosingPairs: Array<IAutoClosingPairConditional>? get() = definedExternally; set(value) = definedExternally
    var surroundingPairs: Array<IAutoClosingPair>? get() = definedExternally; set(value) = definedExternally
    var __electricCharacterSupport: IBracketElectricCharacterContribution? get() = definedExternally; set(value) = definedExternally
}
external interface IndentationRule {
    var decreaseIndentPattern: RegExp
    var increaseIndentPattern: RegExp
    var indentNextLinePattern: RegExp? get() = definedExternally; set(value) = definedExternally
    var unIndentedLinePattern: RegExp? get() = definedExternally; set(value) = definedExternally
}
external interface OnEnterRule {
    var beforeText: RegExp
    var afterText: RegExp? get() = definedExternally; set(value) = definedExternally
    var action: EnterAction
}
external interface IBracketElectricCharacterContribution {
    var docComment: IDocComment? get() = definedExternally; set(value) = definedExternally
}
external interface IDocComment {
    var open: String
    var close: String
}
external interface IAutoClosingPair {
    var open: String
    var close: String
}
external interface IAutoClosingPairConditional : IAutoClosingPair {
    var notIn: Array<String>? get() = definedExternally; set(value) = definedExternally
}
external enum class IndentAction {
    None /* = 0 */,
    Indent /* = 1 */,
    IndentOutdent /* = 2 */,
    Outdent /* = 3 */
}
external interface EnterAction {
    var indentAction: IndentAction
    var outdentCurrentLine: Boolean? get() = definedExternally; set(value) = definedExternally
    var appendText: String? get() = definedExternally; set(value) = definedExternally
    var removeText: Number? get() = definedExternally; set(value) = definedExternally
}
external interface IState {
    fun clone(): IState
    fun equals(other: IState): Boolean
}
external interface Hover {
    var contents: Array<MarkedString>
    var range: IRange
}
external interface HoverProvider {
    fun provideHover(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Hover | Thenable<Hover> */
}
external interface CodeAction {
    var command: Command
    var score: Number
}
external interface ParameterInformation {
    var label: String
    var documentation: String? get() = definedExternally; set(value) = definedExternally
}
external interface SignatureInformation {
    var label: String
    var documentation: String? get() = definedExternally; set(value) = definedExternally
    var parameters: Array<ParameterInformation>
}
external interface SignatureHelp {
    var signatures: Array<SignatureInformation>
    var activeSignature: Number
    var activeParameter: Number
}
external interface SignatureHelpProvider {
    var signatureHelpTriggerCharacters: Array<String>
    fun provideSignatureHelp(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* SignatureHelp | Thenable<SignatureHelp> */
}
external enum class DocumentHighlightKind {
    Text /* = 0 */,
    Read /* = 1 */,
    Write /* = 2 */
}
external interface DocumentHighlight {
    var range: IRange
    var kind: DocumentHighlightKind
}
external interface DocumentHighlightProvider {
    fun provideDocumentHighlights(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Array<DocumentHighlight> | Thenable<Array<DocumentHighlight>> */
}
external interface ReferenceContext {
    var includeDeclaration: Boolean
}
external interface ReferenceProvider {
    fun provideReferences(model: monaco.editor.IReadOnlyModel, position: Position, context: ReferenceContext, token: CancellationToken): dynamic /* Array<Location> | Thenable<Array<Location>> */
}
external interface Location {
    var uri: Uri
    var range: IRange
}
external interface DefinitionProvider {
    fun provideDefinition(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Location | Array<Location> | Thenable<dynamic /* Location | Array<Location> */> */
}
external interface ImplementationProvider {
    fun provideImplementation(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Location | Array<Location> | Thenable<dynamic /* Location | Array<Location> */> */
}
external interface TypeDefinitionProvider {
    fun provideTypeDefinition(model: monaco.editor.IReadOnlyModel, position: Position, token: CancellationToken): dynamic /* Location | Array<Location> | Thenable<dynamic /* Location | Array<Location> */> */
}
external enum class SymbolKind {
    File /* = 0 */,
    Module /* = 1 */,
    Namespace /* = 2 */,
    Package /* = 3 */,
    Class /* = 4 */,
    Method /* = 5 */,
    Property /* = 6 */,
    Field /* = 7 */,
    Constructor /* = 8 */,
    Enum /* = 9 */,
    Interface /* = 10 */,
    Function /* = 11 */,
    Variable /* = 12 */,
    Constant /* = 13 */,
    String /* = 14 */,
    Number /* = 15 */,
    Boolean /* = 16 */,
    Array /* = 17 */,
    Object /* = 18 */,
    Key /* = 19 */,
    Null /* = 20 */,
    EnumMember /* = 21 */,
    Struct /* = 22 */,
    Event /* = 23 */,
    Operator /* = 24 */,
    TypeParameter /* = 25 */
}
external interface SymbolInformation {
    var name: String
    var containerName: String? get() = definedExternally; set(value) = definedExternally
    var kind: SymbolKind
    var location: Location
}
external interface DocumentSymbolProvider {
    fun provideDocumentSymbols(model: monaco.editor.IReadOnlyModel, token: CancellationToken): dynamic /* Array<SymbolInformation> | Thenable<Array<SymbolInformation>> */
}
external interface TextEdit {
    var range: IRange
    var text: String
    var eol: monaco.editor.EndOfLineSequence? get() = definedExternally; set(value) = definedExternally
}
external interface FormattingOptions {
    var tabSize: Number
    var insertSpaces: Boolean
}
external interface DocumentFormattingEditProvider {
    fun provideDocumentFormattingEdits(model: monaco.editor.IReadOnlyModel, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit> | Thenable<Array<TextEdit>> */
}
external interface DocumentRangeFormattingEditProvider {
    fun provideDocumentRangeFormattingEdits(model: monaco.editor.IReadOnlyModel, range: Range, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit> | Thenable<Array<TextEdit>> */
}
external interface OnTypeFormattingEditProvider {
    var autoFormatTriggerCharacters: Array<String>
    fun provideOnTypeFormattingEdits(model: monaco.editor.IReadOnlyModel, position: Position, ch: String, options: FormattingOptions, token: CancellationToken): dynamic /* Array<TextEdit> | Thenable<Array<TextEdit>> */
}
external interface ILink {
    var range: IRange
    var url: String
}
external interface LinkProvider {
    fun provideLinks(model: monaco.editor.IReadOnlyModel, token: CancellationToken): dynamic /* Array<ILink> | Thenable<Array<ILink>> */
    var resolveLink: ((link: ILink, token: CancellationToken) -> dynamic /* ILink | Thenable<ILink> */)? get() = definedExternally; set(value) = definedExternally
}
external interface IResourceEdit {
    var resource: Uri
    var range: IRange
    var newText: String
}
external interface WorkspaceEdit {
    var edits: Array<IResourceEdit>
    var rejectReason: String? get() = definedExternally; set(value) = definedExternally
}
external interface RenameProvider {
    fun provideRenameEdits(model: monaco.editor.IReadOnlyModel, position: Position, newName: String, token: CancellationToken): dynamic /* WorkspaceEdit | Thenable<WorkspaceEdit> */
}
external interface Command {
    var id: String
    var title: String
    var tooltip: String? get() = definedExternally; set(value) = definedExternally
    var arguments: Array<Any>? get() = definedExternally; set(value) = definedExternally
}
external interface ICodeLensSymbol {
    var range: IRange
    var id: String? get() = definedExternally; set(value) = definedExternally
    var command: Command? get() = definedExternally; set(value) = definedExternally
}
external interface CodeLensProvider {
    var onDidChange: IEvent<CodeLensProvider /* this */>? get() = definedExternally; set(value) = definedExternally
    fun provideCodeLenses(model: monaco.editor.IReadOnlyModel, token: CancellationToken): dynamic /* Array<ICodeLensSymbol> | Thenable<Array<ICodeLensSymbol>> */
    val resolveCodeLens: ((model: monaco.editor.IReadOnlyModel, codeLens: ICodeLensSymbol, token: CancellationToken) -> dynamic /* ICodeLensSymbol | Thenable<ICodeLensSymbol> */)? get() = definedExternally
}
external interface ILanguageExtensionPoint {
    var id: String
    var extensions: Array<String>? get() = definedExternally; set(value) = definedExternally
    var filenames: Array<String>? get() = definedExternally; set(value) = definedExternally
    var filenamePatterns: Array<String>? get() = definedExternally; set(value) = definedExternally
    var firstLine: String? get() = definedExternally; set(value) = definedExternally
    var aliases: Array<String>? get() = definedExternally; set(value) = definedExternally
    var mimetypes: Array<String>? get() = definedExternally; set(value) = definedExternally
    var configuration: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$14` {
    @nativeGetter
    operator fun get(name: String): Array<IMonarchLanguageRule>?
    @nativeSetter
    operator fun set(name: String, value: Array<IMonarchLanguageRule>)
}
external interface IMonarchLanguage {
    var tokenizer: `T$14`
    var ignoreCase: Boolean? get() = definedExternally; set(value) = definedExternally
    var defaultToken: String? get() = definedExternally; set(value) = definedExternally
    var brackets: Array<IMonarchLanguageBracket>? get() = definedExternally; set(value) = definedExternally
    var start: String? get() = definedExternally; set(value) = definedExternally
    var tokenPostfix: String
}
external interface IMonarchLanguageRule {
    var regex: dynamic /* String | RegExp */ get() = definedExternally; set(value) = definedExternally
    var action: IMonarchLanguageAction? get() = definedExternally; set(value) = definedExternally
    var include: String? get() = definedExternally; set(value) = definedExternally
}
external interface IMonarchLanguageAction {
    var group: Array<IMonarchLanguageAction>? get() = definedExternally; set(value) = definedExternally
    var cases: Any? get() = definedExternally; set(value) = definedExternally
    var token: String? get() = definedExternally; set(value) = definedExternally
    var next: String? get() = definedExternally; set(value) = definedExternally
    var switchTo: String? get() = definedExternally; set(value) = definedExternally
    var goBack: Number? get() = definedExternally; set(value) = definedExternally
    var bracket: String? get() = definedExternally; set(value) = definedExternally
    var nextEmbedded: String? get() = definedExternally; set(value) = definedExternally
    var log: String? get() = definedExternally; set(value) = definedExternally
}
external interface IMonarchLanguageBracket {
    var open: String
    var close: String
    var token: String
}
