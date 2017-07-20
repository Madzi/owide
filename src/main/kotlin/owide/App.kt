package owide

import monaco.Editor
import monaco.editor.IEditor
import monaco.editor.IModel
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
        var openCounter = 1;
        val openFiles = hashMapOf<IModel, FileDTO>()
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
            openFiles.put(model, FileDTO("noname${openCounter++}", 0, "plain/text", ArrayBuffer()))
            editor.setModel(model)
        }
        navOpen.onclick = {
            FileSystem.load() {
                fileDTO ->
                println("TYPE: ${fileDTO.type}")
                val model = monacoEditor.createModel(FileUtils.decode8(fileDTO.raw), defLanguage)
                openFiles.put(model, fileDTO)
                editor.setModel(model)
            }
        }
        navSave.onclick = {
            val model = editor.getModel();
            val oldDTO = openFiles.get(model)!!
            val newDTO = FileDTO(oldDTO.name, 0, oldDTO.type, FileUtils.encode16(model.getValue()))
            FileSystem.save(newDTO)
        }
    }

    // TODO: 0. Need repair save method
    // TODO: 1. Need parse type (mime) to be able define model language
    // TODO: 2. Need keep this information and use it

}
