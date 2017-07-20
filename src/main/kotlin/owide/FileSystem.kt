package owide

import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.files.get
import kotlin.browser.document

external class ArrayBuffer {}
external class Uint8Array(ab: ArrayBuffer) {}

data class FileDTO(val name: String, val size: Int, val type: String, val raw: ArrayBuffer)

object FileSystem {

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

    fun load(callback: (fileDTO: FileDTO) -> Unit) {
        fileInput.onchange = {
            event ->
            val file = fileInput.files!![0] as File
            val reader = FileReader()
            reader.onload = {
                ev ->
                callback(FileDTO(file.name, file.size, file.type, ev.target.asDynamic().result))
            }
            reader.readAsArrayBuffer(file)
        }
        fileInput.click()
    }

    fun save(fileDTO: FileDTO) {
        val base64 = toBase64(fileDTO.raw)
        fileOutput.apply {
            download = fileDTO.name
            href = "data:${fileDTO.type};base64,$base64"
        }
        fileOutput.click();
    }
    fun extension(fileName: String): String {
        val parts = fileName.split(".");
        return if (parts.size > 1) parts.last() else ""
    }

    fun toBase64(raw: ArrayBuffer): String {
        val byteArray = Uint8Array(ArrayBuffer())
        return "" //TODO: need implement
    }

    fun fromBase64(text: String): ArrayBuffer {
        return ArrayBuffer() //TODO: need implement
    }

}
/*
fun String.decrypt(): String = this.map { ch -> ch - 5 }.toString()
fun String.encrypt(): String = this.map { ch -> ch + 5 }.toString()
*/