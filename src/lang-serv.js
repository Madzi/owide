import {encode8, decode8} from './file-codecs';

export class LangServer {
    constructor (o = {}) {
        this.name = o.name || 'noname';
        this.desc = o.desc || '';
        this.type = o.type || 'plain/text';
        this.ext = o.ext || 'txt';
    }
    loadFile (buf) {
        return decode8(buf);
    }
    saveFile (str) {
        return encode8(str);
    }
    isAccept (ext) {
        return ext == this.ext;
    }
}
