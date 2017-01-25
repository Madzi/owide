import {IdeFile} from './ide-file';
import {fileExt} from './file-codecs';
import {LangServer} from './lang-serv';

class IdeCore {
    constructor () {
        this.file = new IdeFile();
        this.langs = {};
        this._initNodes();
        this._loadCallback = function (str) {};
    }
    _initNodes () {
        let self = this;
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
                    ideFile = new IdeFile(file),
                    reader = new FileReader();
                if (ideFile.type == '') {
                    let lang = this._getLang(ideFile);
                    ideFile.type = lang.type;
                }
                reader.addEventListener('load', e => {
                    let content = self._load(e.target.result, ideFile);
                    ideFile.content = content;
                    self._loadCallback(content);
                    console.log(ideFile.type);
                });
                reader.addEventListener('error', e => {
                    alert(`Unable load ${file.name}`);
                });
                self.file = ideFile;
                reader.readAsArrayBuffer(file);
            }
        });
    }
    _getType (file) {
        let type = file && file.type || '',
            ext = fileExt(file.name);
        if (type.length < 1) {
            for (let lang in this.langs) {
                if (lang.isAccept(ext)) {
                    return lang.type;
                }
            }
        }
        return type || 'plain/text';
    }
    _getLang (file) {
        let type = this._getType(file);
        return this.langs[type] || new LangServer();
    }
    _load (buf, file) {
        let lang = this._getLang(file);
        return lang.loadFile(buf);
    }
    _save (str, file) {
        let lang = this._getLang(file);
        return lang.saveFile(str);
    }
    registerLoadCallback (callback) {
        this._loadCallback = callback;
    }
    registerLangServer (lang) {
        if (lang instanceof LangServer) {
            this,langs[lang.type] = lang;
        }
    }
    fileNew () {
        this.file = new IdeFile();
    }
    fileOpen () {
        this._node.openFile.click();
    }
    fileSave () {
        let data = this._save(this.file.content, this.file);
        this._node.saveFile.setAttribute('href', `data:${this.file.type};base64,${data}`);
        this._node.saveFile.setAttribute('download', this.file.name);
        this._node.saveFile.click();
    }
}

export default IdeCore;
