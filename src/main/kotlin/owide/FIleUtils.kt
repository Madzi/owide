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

object FIleUtils {
/*
    private val body: HTMLElement = document.querySelector("body") as HTMLElement

    private val fileInput = buildInput()
    private val fileOutput = buildOutput()
    private var callback: ((String, ArrayBuffer) -> Unit)? = null

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
        fileOutput.onchange = {
            event ->
            val file = fileInput.files!![0] as File
            val reader = FileReader()
            val clb = callback
            reader.onload = {
                ev ->
                if (clb != null) {
                    clb.invoke(file.name, ev.target.asDynamic().result)
                }
            }
            reader.readAsArrayBuffer(file)
        }
        return fileOutput
    }

    fun load(fn: (String, ArrayBuffer) -> Unit) {
        callback = fn;
        fileInput.click()
    }

    fun save(fileName: String, content: ArrayBuffer) {
        val base64 = toBase64(content)
        fileOutput.apply {
            download = fileName
            href = "data:text/plain;base64,$base64"
        }
        fileOutput.click();
    }

    fun extension(fileName: String): String {
        val parts = fileName.split(".");
        return if (parts.size > 1) parts.last() else ""
    }

    fun toBase64(raw: ArrayBuffer): String {
        return "" //TODO: need implement
    }

    fun fromBase64(text: String): ArrayBuffer {
        return ArrayBuffer() //TODO: need implement
    }
*/
}
/*
fun String.decrypt(): String = this.map { ch -> ch - 5 }.toString()
fun String.encrypt(): String = this.map { ch -> ch + 5 }.toString()
*/