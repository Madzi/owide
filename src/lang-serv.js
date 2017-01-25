export class LangServer {
    constructor (o) {
        this.name = o.name || 'noname';
        this.desc = o.desc || '';
    }
    LoadFile (buf) {}
    saveFile (str) {}
}
