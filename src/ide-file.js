export class IdeFile {
    constructor (o) {
        this.name = o.name || 'noname.txt';
        this.type = o.type || 'plain/text';
        this.size = o.size || 0;
        this.content = o.content || '';
        this.ast = null;
    }
}
