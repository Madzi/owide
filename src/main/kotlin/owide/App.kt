package owide

import monaco.Editor
import monaco.editor.IEditor
import monaco.editor.IModel
import org.w3c.dom.HTMLAnchorElement
import owide.files.*
import owide.loader.qsp.Action
import owide.loader.qsp.Game
import owide.loader.qsp.Location
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
        val game = Game()
        val location = Location ()
        val action = Action()

        location.addAction(action)
        game.addLocation(location)

        var openFile = FileSystem.newFile()
        val monacoEditor = monaco["editor"] as Editor
        val editor: IEditor = monaco.editor.create(
                document.getElementById("container"),
                FileView(game.toText(), "qsp")
        )

        val navNew = document.querySelector("#nav-new") as HTMLAnchorElement
        val navOpen = document.querySelector("#nav-open") as HTMLAnchorElement
        val navSave = document.querySelector("#nav-save") as HTMLAnchorElement

        navNew.onclick = {
            openFile = FileSystem.newFile()
            val model = monacoEditor.createModel(openFile.value, defLanguage)
            editor.setModel(model)
        }
        navOpen.onclick = {
            FileSystem.loadFile() {
                file ->
                openFile = file
                println("TYPE: ${openFile.mime}")
                val model = monacoEditor.createModel(openFile.value, TypeResolver.language(openFile))
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
