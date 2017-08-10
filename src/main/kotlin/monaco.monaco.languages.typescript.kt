@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.languages.typescript")
package monaco.languages.typescript

import monaco.IDisposable
import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
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

external enum class ModuleKind {
    None /* = 0 */,
    CommonJS /* = 1 */,
    AMD /* = 2 */,
    UMD /* = 3 */,
    System /* = 4 */,
    ES2015 /* = 5 */
}
external enum class JsxEmit {
    None /* = 0 */,
    Preserve /* = 1 */,
    React /* = 2 */
}
external enum class NewLineKind {
    CarriageReturnLineFeed /* = 0 */,
    LineFeed /* = 1 */
}
external enum class ScriptTarget {
    ES3 /* = 0 */,
    ES5 /* = 1 */,
    ES2015 /* = 2 */,
    ES2016 /* = 3 */,
    ES2017 /* = 4 */,
    ESNext /* = 5 */,
    Latest /* = 5 */
}
external enum class ModuleResolutionKind {
    Classic /* = 1 */,
    NodeJs /* = 2 */
}
external interface CompilerOptions {
    var allowJs: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowSyntheticDefaultImports: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnreachableCode: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnusedLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var alwaysStrict: Boolean? get() = definedExternally; set(value) = definedExternally
    var baseUrl: String? get() = definedExternally; set(value) = definedExternally
    var charset: String? get() = definedExternally; set(value) = definedExternally
    var declaration: Boolean? get() = definedExternally; set(value) = definedExternally
    var declarationDir: String? get() = definedExternally; set(value) = definedExternally
    var disableSizeLimit: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitBOM: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitDecoratorMetadata: Boolean? get() = definedExternally; set(value) = definedExternally
    var experimentalDecorators: Boolean? get() = definedExternally; set(value) = definedExternally
    var forceConsistentCasingInFileNames: Boolean? get() = definedExternally; set(value) = definedExternally
    var importHelpers: Boolean? get() = definedExternally; set(value) = definedExternally
    var inlineSourceMap: Boolean? get() = definedExternally; set(value) = definedExternally
    var inlineSources: Boolean? get() = definedExternally; set(value) = definedExternally
    var isolatedModules: Boolean? get() = definedExternally; set(value) = definedExternally
    var jsx: JsxEmit? get() = definedExternally; set(value) = definedExternally
    var lib: Array<String>? get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var mapRoot: String? get() = definedExternally; set(value) = definedExternally
    var maxNodeModuleJsDepth: Number? get() = definedExternally; set(value) = definedExternally
    var module: ModuleKind? get() = definedExternally; set(value) = definedExternally
    var moduleResolution: ModuleResolutionKind? get() = definedExternally; set(value) = definedExternally
    var newLine: NewLineKind? get() = definedExternally; set(value) = definedExternally
    var noEmit: Boolean? get() = definedExternally; set(value) = definedExternally
    var noEmitHelpers: Boolean? get() = definedExternally; set(value) = definedExternally
    var noEmitOnError: Boolean? get() = definedExternally; set(value) = definedExternally
    var noErrorTruncation: Boolean? get() = definedExternally; set(value) = definedExternally
    var noFallthroughCasesInSwitch: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitAny: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitReturns: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitThis: Boolean? get() = definedExternally; set(value) = definedExternally
    var noUnusedLocals: Boolean? get() = definedExternally; set(value) = definedExternally
    var noUnusedParameters: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitUseStrict: Boolean? get() = definedExternally; set(value) = definedExternally
    var noLib: Boolean? get() = definedExternally; set(value) = definedExternally
    var noResolve: Boolean? get() = definedExternally; set(value) = definedExternally
    var out: String? get() = definedExternally; set(value) = definedExternally
    var outDir: String? get() = definedExternally; set(value) = definedExternally
    var outFile: String? get() = definedExternally; set(value) = definedExternally
    var preserveConstEnums: Boolean? get() = definedExternally; set(value) = definedExternally
    var project: String? get() = definedExternally; set(value) = definedExternally
    var reactNamespace: String? get() = definedExternally; set(value) = definedExternally
    var jsxFactory: String? get() = definedExternally; set(value) = definedExternally
    var removeComments: Boolean? get() = definedExternally; set(value) = definedExternally
    var rootDir: String? get() = definedExternally; set(value) = definedExternally
    var rootDirs: Array<String>? get() = definedExternally; set(value) = definedExternally
    var skipLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var skipDefaultLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceMap: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceRoot: String? get() = definedExternally; set(value) = definedExternally
    var strictNullChecks: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressExcessPropertyErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressImplicitAnyIndexErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var target: ScriptTarget? get() = definedExternally; set(value) = definedExternally
    var traceResolution: Boolean? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var typeRoots: Array<String>? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    operator fun get(option: String): dynamic /* String | Number | Boolean | Array<dynamic /* String | Number */> | Array<String> | Nothing? */
    @nativeSetter
    operator fun set(option: String, value: String)
    @nativeSetter
    operator fun set(option: String, value: Number)
    @nativeSetter
    operator fun set(option: String, value: Boolean)
    @nativeSetter
    operator fun set(option: String, value: Array<dynamic /* String | Number */>)
    @nativeSetter
    operator fun set(option: String, value: Array<String>)
    @nativeSetter
    operator fun set(option: String, value: Nothing?)
}
external interface DiagnosticsOptions {
    var noSemanticValidation: Boolean? get() = definedExternally; set(value) = definedExternally
    var noSyntaxValidation: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface LanguageServiceDefaults {
    fun addExtraLib(content: String, filePath: String? = definedExternally /* null */): IDisposable
    fun setCompilerOptions(options: CompilerOptions)
    fun setDiagnosticsOptions(options: DiagnosticsOptions)
    fun setMaximunWorkerIdleTime(value: Number)
    fun setEagerModelSync(value: Boolean)
}
external var typescriptDefaults: LanguageServiceDefaults = definedExternally
external var javascriptDefaults: LanguageServiceDefaults = definedExternally
external var getTypeScriptWorker: () -> monaco.Promise<Any> = definedExternally
external var getJavaScriptWorker: () -> monaco.Promise<Any> = definedExternally
