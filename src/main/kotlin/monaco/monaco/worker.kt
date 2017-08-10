@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("monaco.worker")
package monaco.worker

import monaco.Uri
import kotlin.js.*

external interface IMirrorModel {
    var uri: Uri
    var version: Number
    fun getValue(): String
}
external interface IWorkerContext {
    /**
     * Get all available mirror models in this worker.
     */
    fun getMirrorModels(): Array<IMirrorModel>
}
