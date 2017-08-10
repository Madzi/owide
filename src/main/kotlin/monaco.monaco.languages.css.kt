@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.languages.css")
package monaco.languages.css

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

external interface `T$15` {
    var compatibleVendorPrefixes: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var vendorPrefix: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var duplicateProperties: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var emptyRules: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var importStatement: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var boxModel: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var universalSelector: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var zeroUnits: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var fontFaceProperties: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var hexColorLength: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var argumentsInColorFunction: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var unknownProperties: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var ieHack: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var unknownVendorSpecificProperties: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var propertyIgnoredDueToDisplay: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var important: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var float: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
    var idSelector: dynamic /* Any /* "ignore" */ | Any /* "warning" */ | Any /* "error" */ */ get() = definedExternally; set(value) = definedExternally
}
external interface DiagnosticsOptions {
    var validate: Boolean? get() = definedExternally; set(value) = definedExternally
    var lint: `T$15`? get() = definedExternally; set(value) = definedExternally
}
external interface LanguageServiceDefaults {
    var onDidChange: IEvent<LanguageServiceDefaults>
    var diagnosticsOptions: DiagnosticsOptions
    fun setDiagnosticsOptions(options: DiagnosticsOptions)
}
external var cssDefaults: LanguageServiceDefaults = definedExternally
external var lessDefaults: LanguageServiceDefaults = definedExternally
external var scssDefaults: LanguageServiceDefaults = definedExternally
