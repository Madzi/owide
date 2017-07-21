package owide.files

external object FileUtils {
    fun encode8(content: String): ArrayBuffer
    fun decode8(buffer: ArrayBuffer): String
    fun encode16(content: String): ArrayBuffer
    fun decode16(buffer: ArrayBuffer): String
    fun encode32(content: String): ArrayBuffer
    fun decode32(buffer: ArrayBuffer): String
    fun toBase64(buffer: ArrayBuffer): String
}
