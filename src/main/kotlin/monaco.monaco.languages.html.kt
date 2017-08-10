@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.languages.html")
package monaco.languages.html

import monaco.IEvent
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

external interface HTMLFormatConfiguration {
    var tabSize: Number
    var insertSpaces: Boolean
    var wrapLineLength: Number
    var unformatted: String
    var contentUnformatted: String
    var indentInnerHtml: Boolean
    var preserveNewLines: Boolean
    var maxPreserveNewLines: Number
    var indentHandlebars: Boolean
    var endWithNewline: Boolean
    var extraLiners: String
    var wrapAttributes: dynamic /* Any /* "auto" */ | Any /* "force" */ | Any /* "force-aligned" */ | Any /* "force-expand-multiline" */ */
}
external interface CompletionConfiguration {
    @nativeGetter
    operator fun get(provider: String): Boolean?
    @nativeSetter
    operator fun set(provider: String, value: Boolean)
}
external interface Options {
    var format: HTMLFormatConfiguration? get() = definedExternally; set(value) = definedExternally
    var suggest: CompletionConfiguration? get() = definedExternally; set(value) = definedExternally
}
external interface LanguageServiceDefaults {
    var onDidChange: IEvent<LanguageServiceDefaults>
    var options: Options
    fun setOptions(options: Options)
}
external var htmlDefaults: LanguageServiceDefaults = definedExternally
external var handlebarDefaults: LanguageServiceDefaults = definedExternally
external var razorDefaults: LanguageServiceDefaults = definedExternally
