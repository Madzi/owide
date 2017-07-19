package owide.ui

import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.files.get
import kotlin.browser.document

external class ArrayBuffer

object FileSystem {

    private val body = document.querySelector("body") as HTMLElement
    private val inputer = initInputer()
    private val outputer = initOutputer()
    private var callback: ((fileName: String, content: ArrayBuffer) -> Unit)? = null

    private fun initInputer(): HTMLInputElement {
        val fin = document.createElement("input") as HTMLInputElement
        fin.apply {
            type = "file"
            style.display = "none"
        }
        body.appendChild(fin)
        fin.onchange = {
            event ->
            val file: File? = inputer.files!![0] as File
            if (file != null) {
                val reader = FileReader()
                reader.onload = {
                    ev ->
                    if (callback != null) {
                        callback?.invoke(file.name, ev.target.asDynamic().result)
                    }
                }
                reader.readAsArrayBuffer(file)
            }
        }
        return fin
    }
    private fun initOutputer(): HTMLAnchorElement {
        val fout = document.createElement("a") as HTMLAnchorElement
        fout.apply {
            style.display = "none"
        }
        body.appendChild(fout)
        return fout
    }

    fun load(callback: (fileName: String, context: ArrayBuffer) -> Unit) {
        FileSystem.callback = callback
        inputer.click()
    }

    fun save(fileName: String, context: ArrayBuffer) {
        outputer.href = "data:text/plain;base64,+++";
        outputer.download = fileName
        outputer.click()
    }

    fun extension(fileName: String): String {
        val parts = fileName.split(".")
        return if (parts.size > 1) parts.last() else ""
    }

}