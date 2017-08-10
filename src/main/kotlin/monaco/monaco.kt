@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco")
package monaco

import org.w3c.dom.HTMLElement
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.events.MouseEvent

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

external interface Thenable<T> {
    fun <TResult> then(onfulfilled: ((value: T) -> dynamic /* TResult | Thenable<TResult> */)? = definedExternally /* null */, onrejected: ((reason: Any) -> dynamic /* TResult | Thenable<TResult> */)? = definedExternally /* null */): Thenable<TResult>
    fun <TResult> then(onfulfilled: ((value: T) -> dynamic /* TResult | Thenable<TResult> */)? = definedExternally /* null */, onrejected: ((reason: Any) -> Unit)? = definedExternally /* null */): Thenable<TResult>
}
external interface IDisposable {
    fun dispose()
}
external interface IEvent<T> {
    operator fun invoke(listener: (e: T) -> Any, thisArg: Any? = definedExternally /* null */): IDisposable
}
external open class Emitter<T> {
    open val event: IEvent<T> = definedExternally
    open fun fire(event: T? = definedExternally /* null */): Unit = definedExternally
    open fun dispose(): Unit = definedExternally
}
external enum class Severity {
    Ignore /* = 0 */,
    Info /* = 1 */,
    Warning /* = 2 */,
    Error /* = 3 */
}
external interface TValueCallback<T> {
    operator fun invoke(value: T)
}
external interface ProgressCallback {
    operator fun invoke(progress: Any): Any
}
external interface `T$0` {
    @nativeGetter
    operator fun get(n: String): Promise<ValueType>?
    @nativeSetter
    operator fun set(n: String, value: Promise<ValueType>)
}
external interface `T$1`<ValueType> {
    @nativeGetter
    operator fun get(n: String): ValueType?
    @nativeSetter
    operator fun set(n: String, value: ValueType)
}
external interface `T$2` {
    var key: String
    var value: Promise<ValueType>
}
external open class Promise<V>(init: (complete: TValueCallback<V>, error: (err: Any) -> Unit, progress: ProgressCallback) -> Unit, oncancel: Any? = definedExternally /* null */) {
    open fun <U> then(success: ((value: V) -> Promise<U>)? = definedExternally /* null */, error: ((err: Any) -> Promise<U>)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> Promise<U>)? = definedExternally /* null */, error: ((err: Any) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> Promise<U>)? = definedExternally /* null */, error: ((err: Any) -> U)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> Promise<U>)? = definedExternally /* null */, error: ((err: Any) -> Unit)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, error: ((err: Any) -> Promise<U>)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, error: ((err: Any) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, error: ((err: Any) -> U)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, error: ((err: Any) -> Unit)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> U)? = definedExternally /* null */, error: ((err: Any) -> Promise<U>)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> U)? = definedExternally /* null */, error: ((err: Any) -> dynamic /* Promise<U> | U */)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> U)? = definedExternally /* null */, error: ((err: Any) -> U)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun <U> then(success: ((value: V) -> U)? = definedExternally /* null */, error: ((err: Any) -> Unit)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Promise<U> = definedExternally
    open fun done(success: ((value: V) -> Unit)? = definedExternally /* null */, error: ((err: Any) -> Any)? = definedExternally /* null */, progress: ProgressCallback? = definedExternally /* null */): Unit = definedExternally
    open fun cancel(): Unit = definedExternally
    companion object {
        fun `as`(value: Nothing?): Promise<Nothing?> = definedExternally
        fun `as`(value: Nothing?): Promise<Nothing?> = definedExternally
        fun <ValueType> `as`(value: Promise<ValueType>): Promise<ValueType> = definedExternally
        fun <ValueType> `as`(value: Thenable<ValueType>): Thenable<ValueType> = definedExternally
        fun <ValueType> `as`(value: ValueType): Promise<ValueType> = definedExternally
        fun `is`(value: Any): Boolean = definedExternally
        fun timeout(delay: Number): Promise<Unit> = definedExternally
        fun <ValueType> join(promises: Array<Promise<ValueType>>): Promise<Array<ValueType>> = definedExternally
        fun <ValueType> join(promises: Array<Thenable<ValueType>>): Thenable<Array<ValueType>> = definedExternally
        fun <ValueType> join(promises: `T$0`): Promise<`T$1`<ValueType>> = definedExternally
        fun <ValueType> any(promises: Array<Promise<ValueType>>): Promise<`T$2`> = definedExternally
        fun <ValueType> wrap(value: Thenable<ValueType>): Promise<ValueType> = definedExternally
        fun <ValueType> wrap(value: ValueType): Promise<ValueType> = definedExternally
        fun <ValueType> wrapError(error: Error): Promise<ValueType> = definedExternally
    }
}
external open class CancellationTokenSource {
    open var token: CancellationToken = definedExternally
    open fun cancel(): Unit = definedExternally
    open fun dispose(): Unit = definedExternally
}
external interface CancellationToken {
    var isCancellationRequested: Boolean
    var onCancellationRequested: IEvent<Any>
}
external interface `T$3` {
    var scheme: String? get() = definedExternally; set(value) = definedExternally
    var authority: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var query: String? get() = definedExternally; set(value) = definedExternally
    var fragment: String? get() = definedExternally; set(value) = definedExternally
}
external interface `T$4` {
    var scheme: String? get() = definedExternally; set(value) = definedExternally
    var authority: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var query: String? get() = definedExternally; set(value) = definedExternally
    var fragment: String? get() = definedExternally; set(value) = definedExternally
}
external open class Uri {
    open var scheme: String = definedExternally
    open var authority: String = definedExternally
    open var path: String = definedExternally
    open var query: String = definedExternally
    open var fragment: String = definedExternally
    open var fsPath: String = definedExternally
    open fun with(change: `T$3`): Uri = definedExternally
    open fun toString(skipEncoding: Boolean? = definedExternally /* null */): String = definedExternally
    open fun toJSON(): Any = definedExternally
    companion object {
        fun isUri(thing: Any): Boolean = definedExternally
        fun parse(value: String): Uri = definedExternally
        fun file(path: String): Uri = definedExternally
        fun from(components: `T$4`): Uri = definedExternally
        fun revive(data: Any): Uri = definedExternally
    }
}
external enum class KeyCode {
    Unknown /* = 0 */,
    Backspace /* = 1 */,
    Tab /* = 2 */,
    Enter /* = 3 */,
    Shift /* = 4 */,
    Ctrl /* = 5 */,
    Alt /* = 6 */,
    PauseBreak /* = 7 */,
    CapsLock /* = 8 */,
    Escape /* = 9 */,
    Space /* = 10 */,
    PageUp /* = 11 */,
    PageDown /* = 12 */,
    End /* = 13 */,
    Home /* = 14 */,
    LeftArrow /* = 15 */,
    UpArrow /* = 16 */,
    RightArrow /* = 17 */,
    DownArrow /* = 18 */,
    Insert /* = 19 */,
    Delete /* = 20 */,
    KEY_0 /* = 21 */,
    KEY_1 /* = 22 */,
    KEY_2 /* = 23 */,
    KEY_3 /* = 24 */,
    KEY_4 /* = 25 */,
    KEY_5 /* = 26 */,
    KEY_6 /* = 27 */,
    KEY_7 /* = 28 */,
    KEY_8 /* = 29 */,
    KEY_9 /* = 30 */,
    KEY_A /* = 31 */,
    KEY_B /* = 32 */,
    KEY_C /* = 33 */,
    KEY_D /* = 34 */,
    KEY_E /* = 35 */,
    KEY_F /* = 36 */,
    KEY_G /* = 37 */,
    KEY_H /* = 38 */,
    KEY_I /* = 39 */,
    KEY_J /* = 40 */,
    KEY_K /* = 41 */,
    KEY_L /* = 42 */,
    KEY_M /* = 43 */,
    KEY_N /* = 44 */,
    KEY_O /* = 45 */,
    KEY_P /* = 46 */,
    KEY_Q /* = 47 */,
    KEY_R /* = 48 */,
    KEY_S /* = 49 */,
    KEY_T /* = 50 */,
    KEY_U /* = 51 */,
    KEY_V /* = 52 */,
    KEY_W /* = 53 */,
    KEY_X /* = 54 */,
    KEY_Y /* = 55 */,
    KEY_Z /* = 56 */,
    Meta /* = 57 */,
    ContextMenu /* = 58 */,
    F1 /* = 59 */,
    F2 /* = 60 */,
    F3 /* = 61 */,
    F4 /* = 62 */,
    F5 /* = 63 */,
    F6 /* = 64 */,
    F7 /* = 65 */,
    F8 /* = 66 */,
    F9 /* = 67 */,
    F10 /* = 68 */,
    F11 /* = 69 */,
    F12 /* = 70 */,
    F13 /* = 71 */,
    F14 /* = 72 */,
    F15 /* = 73 */,
    F16 /* = 74 */,
    F17 /* = 75 */,
    F18 /* = 76 */,
    F19 /* = 77 */,
    NumLock /* = 78 */,
    ScrollLock /* = 79 */,
    US_SEMICOLON /* = 80 */,
    US_EQUAL /* = 81 */,
    US_COMMA /* = 82 */,
    US_MINUS /* = 83 */,
    US_DOT /* = 84 */,
    US_SLASH /* = 85 */,
    US_BACKTICK /* = 86 */,
    US_OPEN_SQUARE_BRACKET /* = 87 */,
    US_BACKSLASH /* = 88 */,
    US_CLOSE_SQUARE_BRACKET /* = 89 */,
    US_QUOTE /* = 90 */,
    OEM_8 /* = 91 */,
    OEM_102 /* = 92 */,
    NUMPAD_0 /* = 93 */,
    NUMPAD_1 /* = 94 */,
    NUMPAD_2 /* = 95 */,
    NUMPAD_3 /* = 96 */,
    NUMPAD_4 /* = 97 */,
    NUMPAD_5 /* = 98 */,
    NUMPAD_6 /* = 99 */,
    NUMPAD_7 /* = 100 */,
    NUMPAD_8 /* = 101 */,
    NUMPAD_9 /* = 102 */,
    NUMPAD_MULTIPLY /* = 103 */,
    NUMPAD_ADD /* = 104 */,
    NUMPAD_SEPARATOR /* = 105 */,
    NUMPAD_SUBTRACT /* = 106 */,
    NUMPAD_DECIMAL /* = 107 */,
    NUMPAD_DIVIDE /* = 108 */,
    KEY_IN_COMPOSITION /* = 109 */,
    ABNT_C1 /* = 110 */,
    ABNT_C2 /* = 111 */,
    MAX_VALUE /* = 112 */
}
external open class KeyMod {
    companion object {
        var CtrlCmd: Number = definedExternally
        var Shift: Number = definedExternally
        var Alt: Number = definedExternally
        var WinCtrl: Number = definedExternally
        fun chord(firstPart: Number, secondPart: Number): Number = definedExternally
    }
}
external interface `T$5` {
    var language: String
    var value: String
}
external interface IKeyboardEvent {
    var browserEvent: KeyboardEvent
    var target: HTMLElement
    var ctrlKey: Boolean
    var shiftKey: Boolean
    var altKey: Boolean
    var metaKey: Boolean
    var keyCode: KeyCode
    var code: String
    fun equals(keybinding: Number): Boolean
    fun preventDefault()
    fun stopPropagation()
}
external interface IMouseEvent {
    var browserEvent: MouseEvent
    var leftButton: Boolean
    var middleButton: Boolean
    var rightButton: Boolean
    var target: HTMLElement
    var detail: Number
    var posx: Number
    var posy: Number
    var ctrlKey: Boolean
    var shiftKey: Boolean
    var altKey: Boolean
    var metaKey: Boolean
    var timestamp: Number
    fun preventDefault()
    fun stopPropagation()
}
external interface IScrollEvent {
    var scrollTop: Number
    var scrollLeft: Number
    var scrollWidth: Number
    var scrollHeight: Number
    var scrollTopChanged: Boolean
    var scrollLeftChanged: Boolean
    var scrollWidthChanged: Boolean
    var scrollHeightChanged: Boolean
}
external interface IPosition {
    var lineNumber: Number
    var column: Number
}
external open class Position(lineNumber: Number, column: Number) {
    open var lineNumber: Number = definedExternally
    open var column: Number = definedExternally
    open fun equals(other: IPosition): Boolean = definedExternally
    open fun isBefore(other: IPosition): Boolean = definedExternally
    open fun isBeforeOrEqual(other: IPosition): Boolean = definedExternally
    open fun clone(): Position = definedExternally
    override fun toString(): String = definedExternally
    companion object {
        fun equals(a: IPosition, b: IPosition): Boolean = definedExternally
        fun isBefore(a: IPosition, b: IPosition): Boolean = definedExternally
        fun isBeforeOrEqual(a: IPosition, b: IPosition): Boolean = definedExternally
        fun compare(a: IPosition, b: IPosition): Number = definedExternally
        fun lift(pos: IPosition): Position = definedExternally
        fun isIPosition(obj: Any): Boolean = definedExternally
    }
}
external interface IRange {
    var startLineNumber: Number
    var startColumn: Number
    var endLineNumber: Number
    var endColumn: Number
}
external open class Range(startLineNumber: Number, startColumn: Number, endLineNumber: Number, endColumn: Number) {
    open var startLineNumber: Number = definedExternally
    open var startColumn: Number = definedExternally
    open var endLineNumber: Number = definedExternally
    open var endColumn: Number = definedExternally
    open fun isEmpty(): Boolean = definedExternally
    open fun containsPosition(position: IPosition): Boolean = definedExternally
    open fun containsRange(range: IRange): Boolean = definedExternally
    open fun plusRange(range: IRange): Range = definedExternally
    open fun intersectRanges(range: IRange): Range = definedExternally
    open fun equalsRange(other: IRange): Boolean = definedExternally
    open fun getEndPosition(): Position = definedExternally
    open fun getStartPosition(): Position = definedExternally
    open fun cloneRange(): Range = definedExternally
    override fun toString(): String = definedExternally
    open fun setEndPosition(endLineNumber: Number, endColumn: Number): Range = definedExternally
    open fun setStartPosition(startLineNumber: Number, startColumn: Number): Range = definedExternally
    open fun collapseToStart(): Range = definedExternally
    companion object {
        fun isEmpty(range: IRange): Boolean = definedExternally
        fun containsPosition(range: IRange, position: IPosition): Boolean = definedExternally
        fun containsRange(range: IRange, otherRange: IRange): Boolean = definedExternally
        fun plusRange(a: IRange, b: IRange): Range = definedExternally
        fun intersectRanges(a: IRange, b: IRange): Range = definedExternally
        fun equalsRange(a: IRange, b: IRange): Boolean = definedExternally
        fun collapseToStart(range: IRange): Range = definedExternally
        fun fromPositions(start: IPosition, end: IPosition? = definedExternally /* null */): Range = definedExternally
        fun lift(range: IRange): Range = definedExternally
        fun isIRange(obj: Any): Boolean = definedExternally
        fun areIntersectingOrTouching(a: IRange, b: IRange): Boolean = definedExternally
        fun compareRangesUsingStarts(a: IRange, b: IRange): Number = definedExternally
        fun compareRangesUsingEnds(a: IRange, b: IRange): Number = definedExternally
        fun spansMultipleLines(range: IRange): Boolean = definedExternally
    }
}
external interface ISelection {
    var selectionStartLineNumber: Number
    var selectionStartColumn: Number
    var positionLineNumber: Number
    var positionColumn: Number
}
external open class Selection(selectionStartLineNumber: Number, selectionStartColumn: Number, positionLineNumber: Number, positionColumn: Number) : Range {
    open var selectionStartLineNumber: Number = definedExternally
    open var selectionStartColumn: Number = definedExternally
    open var positionLineNumber: Number = definedExternally
    open var positionColumn: Number = definedExternally
    open fun clone(): Selection = definedExternally
    override fun toString(): String = definedExternally
    open fun equalsSelection(other: ISelection): Boolean = definedExternally
    open fun getDirection(): SelectionDirection = definedExternally
    override fun setEndPosition(endLineNumber: Number, endColumn: Number): Selection = definedExternally
    open fun getPosition(): Position = definedExternally
    override fun setStartPosition(startLineNumber: Number, startColumn: Number): Selection = definedExternally
    companion object {
        fun selectionsEqual(a: ISelection, b: ISelection): Boolean = definedExternally
        fun fromPositions(start: IPosition, end: IPosition? = definedExternally /* null */): Selection = definedExternally
        fun liftSelection(sel: ISelection): Selection = definedExternally
        fun selectionsArrEqual(a: Array<ISelection>, b: Array<ISelection>): Boolean = definedExternally
        fun isISelection(obj: Any): Boolean = definedExternally
        fun createWithDirection(startLineNumber: Number, startColumn: Number, endLineNumber: Number, endColumn: Number, direction: SelectionDirection): Selection = definedExternally
    }
}
external enum class SelectionDirection {
    LTR /* = 0 */,
    RTL /* = 1 */
}
external open class Token(offset: Number, type: String, language: String) {
    open var _tokenBrand: dynamic = definedExternally
    open var offset: Number = definedExternally
    open var type: String = definedExternally
    open var language: String = definedExternally
    override fun toString(): String = definedExternally
}
