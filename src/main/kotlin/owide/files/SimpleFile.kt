package owide.files

open class SimpleFile(val name: String, val mime: String = "plain/text", var value: String) {
    open fun fromRaw(arrayBuffer: ArrayBuffer) {
        value = FileUtils.decode8(arrayBuffer)
    }
    open fun toRaw(): ArrayBuffer {
        return FileUtils.encode8(value)
    }
    fun base64(): String {
        return FileUtils.toBase64(toRaw())
    }
    fun asLink(): String {
        return "data:${mime};base64,${base64()}"
    }
}