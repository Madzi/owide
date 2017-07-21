package owide.files

import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.files.get
import kotlin.browser.document

external class ArrayBuffer {}
external class Uint8Array(ab: ArrayBuffer) {}

object FileSystem {

    private var fid = 1;

    private val body: HTMLElement = document.querySelector("body") as HTMLElement

    private val fileInput = buildInput()
    private val fileOutput = buildOutput()

    private fun buildInput(): HTMLInputElement {
        val fileInput = document.createElement("input") as HTMLInputElement
        fileInput.apply {
            type = "file"
            style.display = "none"
        }
        body.appendChild(fileInput)
        return fileInput
    }

    private fun buildOutput(): HTMLAnchorElement {
        val fileOutput = document.createElement("a") as HTMLAnchorElement
        fileOutput.apply {
            style.display = "none"
        }
        body.appendChild(fileOutput)
        return fileOutput
    }

    fun newFile(): SimpleFile {
        return SimpleFile("Noname ${fid++}", "plain/text", "")
    }

    fun loadFile(callback: (simpleFile: SimpleFile) -> Unit) {
        fileInput.onchange = {
            event ->
            val file = fileInput.files!![0] as File
            val reader = FileReader()
            reader.onload = {
                ev ->
                val simpleFile = SimpleFile(file.name, detectMime(file), "")
                println("file.type :: ${file.type}, mime :: ${simpleFile.mime}")
                simpleFile.fromRaw(ev.target.asDynamic().result)
                callback(simpleFile)
            }
            reader.readAsArrayBuffer(file)
        }
        fileInput.click()
    }

    fun saveFile(simpleFile: SimpleFile) {
        fileOutput.apply {
            download = simpleFile.name
            href = simpleFile.asLink()
        }
        fileOutput.click();
    }
    fun extension(fileName: String): String {
        val parts = fileName.split(".");
        return if (parts.size > 1) parts.last() else ""
    }
    fun detectMime(file: File): String {
        return "plain/text"
    }

}
