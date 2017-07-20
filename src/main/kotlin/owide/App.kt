package owide

import monaco.Editor
import monaco.editor.IEditor
import org.w3c.dom.HTMLAnchorElement
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
        val monacoEditor = monaco["editor"] as Editor
        val editor: IEditor = monaco.editor.create(
                document.getElementById("container"),
                FileView("function x() {\n}\n", "javascript")
        )

        val navNew = document.querySelector("#nav-new") as HTMLAnchorElement
        val navOpen = document.querySelector("#nav-open") as HTMLAnchorElement
        val navSave = document.querySelector("#nav-save") as HTMLAnchorElement

        navNew.onclick = {
            val model = monacoEditor.createModel("", defLanguage)
            editor.setModel(model)
        }
        navOpen.onclick = {
            FileSystem.load() {
                fileDTO ->
                val model = monacoEditor.createModel(fileDTO.name, defLanguage)
                editor.setModel(model)
            }
        }
        navSave.onclick = {
//            val model = editor.getModel();
            //FileSystem.save(FileDTO(fileName, ))
        }
    }


}
