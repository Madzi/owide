@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.languages.json")
package monaco.languages.json

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

external interface T16 {
    var uri: String
    var fileMatch: Array<String>? get() = definedExternally; set(value) = definedExternally
    var schema: Any? get() = definedExternally; set(value) = definedExternally
}
external interface DiagnosticsOptions {
    var validate: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowComments: Boolean? get() = definedExternally; set(value) = definedExternally
    var schemas: Array<T16>? get() = definedExternally; set(value) = definedExternally
}
external interface LanguageServiceDefaults {
    var onDidChange: IEvent<LanguageServiceDefaults>
    var diagnosticsOptions: DiagnosticsOptions
    fun setDiagnosticsOptions(options: DiagnosticsOptions)
}
external var jsonDefaults: LanguageServiceDefaults = definedExternally
