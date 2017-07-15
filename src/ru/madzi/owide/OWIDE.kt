package ru.madzi.owide

import org.w3c.dom.Element
import kotlin.browser.document

class EditorConfig(val value: String, val theme: String, val language: String) {
}

external class Editor {
    fun create(tag: Element?, config: EditorConfig)
}

external class Monaco {
    val editor: Editor
}

external fun require(libs: Any, fn: () -> Unit)
external val monaco: Monaco

fun main(args: Array<String>) {
    js("require.config({ paths: { 'vs': 'js/vs' }})")
    require(arrayOf("vs/editor/editor.main")) {
        val config = EditorConfig(
                "function x() {\n\tconsole.log('Hello world!');\n}\n",
                "vs-dark",
                "javascript"
        )
        val editor = monaco.editor.create(document.querySelector("#container"), config);
    }
    println("Welcome to OWIDE")
}