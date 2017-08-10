package owide

import monaco.editor.IEditor
import monaco.editor.IModel
import org.w3c.dom.HTMLAnchorElement
import owide.files.*
import kotlin.browser.document

data class Paths(val vs: String)
data class RConf(val paths: Paths)

external val require: (libs: Array<String>, fn: () -> Unit) -> Unit
val config: (conf: RConf) -> Unit = require.asDynamic().config

external val monaco: dynamic

val defLanguage = "javascript"

data class FileView(val value: String, val language: String)

fun main (args: Array<String>) {

    config(RConf(Paths("lib/vs")))
    require(arrayOf("vs/editor/editor.main")) {
        var openFile = FileSystem.newFile()
        val editor: IEditor = monaco.editor.create(
                document.getElementById("container"),
                FileView("function x() {\n}\n", "javascript")
        )

        val navNew = document.querySelector("#nav-new") as HTMLAnchorElement
        val navOpen = document.querySelector("#nav-open") as HTMLAnchorElement
        val navSave = document.querySelector("#nav-save") as HTMLAnchorElement

        navNew.onclick = {
            openFile = FileSystem.newFile()
            val model: IModel = monaco.monaco.editor.createModel(openFile.value, defLanguage)
            editor.setModel(model)
        }
        navOpen.onclick = {
            FileSystem.loadFile() {
                file ->
                openFile = file
                println("TYPE: ${openFile.mime}")
                val model: IModel = monaco.monaco.editor.createModel(openFile.value, TypeResolver.language(openFile))
                editor.setModel(model)
            }
        }
        navSave.onclick = {
            val model = editor.getModel();
            openFile.value = model.getValue()
            FileSystem.saveFile(openFile)
        }
    }

}
