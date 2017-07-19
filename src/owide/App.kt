package owide

import kotlin.browser.document

data class Paths(val vs: String)
data class RConf(val paths: Paths)

external val require: (libs: Array<String>, fn: () -> Unit) -> Unit
val config: (conf: RConf) -> Unit = require.asDynamic().config

external val monaco: dynamic

data class FileView(val value: String, val language: String)

fun main (args: Array<String>) {

    config(RConf(Paths("lib/vs")))
    require(arrayOf("vs/editor/editor.main")) {
        val editor = monaco.editor.create(document.getElementById("container"), FileView("function x() {\n}\n", "javascript"))
    }
}
