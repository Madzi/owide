import IdeFile from './ide-file';

let _encode = function (str, bufView) {
        for (let i = 0, len = str.length; i < len; ++i) {
            bufView[i] = str.charCodeAt(i);
        }
    },
    _encode8 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint8Array(buf));
        return buf;
    },
    _encode16 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint16Array(buf));
        return buf;
    },
    _encode32 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint32Array(buf));
        return buf;
    },
    _decode = function (bufView) {
        let strBuf = [];
        for (let i = 0, len = bufView.length; i < len; ++i) {
            strBuf.push(String.fromCharCode(bufView[i]));
        }
        return strBuf.join('');
    },
    _decode8 = function (buf) { return _decode(new Uint8Array(buf)); },
    _decode16 = function (buf) { return _decode(new Uint16Array(buf)); },
    _decode32 = function (buf) { return _decode(new Uint32Array(buf)); };

export class IdeCore {
    constructor () {
        this.file = new IdeFile();
        this._initNodes();
    }
    _initNodes () {
        this._node = {
            openFile: document.createElement('input'),
            saveFile: document.createElement('a')
        };
        this._node.openFile.style.display = 'none';
        this._node.saveFile.style.display = 'none';
        this._node.openFile.type = 'file';
        this._node.saveFile.setAttribute('href', '#');
        this._node.openFile.addEventListener('change', e => {
            let files = e.target.files;
            for (let i = 0, len = files.length; i < len; ++i) {
                let file = files[i],
                    reader = new FileReader();
                reader.addEventListener('load', e => {
                });
                reader.addEventListener('error', e => {
                    alert(`Unable load ${file.name}`);
                });
                reader.readAsArrayBuffer(file);
            }
        });
    }
    fileNew () {
        this.file = new IdeFile();
    }
    fileOpen (file) {
        this.file = new IdeFile();
    }
    fileSave (ideFile) {
        let data = btoa(_encode8(this.file.content));
        this._node.saveFile.setAttribute('href', `data:${this.file.type};base64,${data}`);
        this._node.saveFile.setAttribute('download', this.file.name);
        this._node.saveFile.click();
    }
}
