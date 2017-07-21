package owide.files

import owide.loader.QspLoader

class QspFile(name: String, value: String) : SimpleFile(name, "application/x-qsp", value) {
    override fun fromRaw(arrayBuffer: ArrayBuffer) {
        value = QspLoader.gamToTxt(FileUtils.decode16(arrayBuffer))
    }
    override fun toRaw(): ArrayBuffer {
        return FileUtils.encode16(QspLoader.txtToGam(value))
    }
}
