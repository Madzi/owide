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
                val mime = detectMime(file)
                val ideFile = when (mime) {
                    "application/x-qsp" -> QspFile(file.name, "")
                    else -> SimpleFile(file.name, mime, "")
                }
                println("file.type :: ${file.type}, mime :: ${ideFile.mime}")
                ideFile.fromRaw(ev.target.asDynamic().result)
                callback(ideFile)
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
        if (file.type.isNotEmpty()) {
            return file.type
        }
        val ext = extension(file.name)
        println(ext)
        return when(ext) {
            "bat" -> "application/x-bat"
            "jar" -> "archive/jar"
            "java" -> "application/x-java"
            "md" -> "application/x-markdown"
            "qsp" -> "application/x-qsp"
            else -> "plain/text"
        }
    }

}
