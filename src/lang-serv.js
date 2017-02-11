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

export class LangServerOberon07 extends LangServer {
    constructor (o = {}) {
        super ({
            name: 'oberon07',
            desc: 'Programming language Oberon 07',
            type: 'text/x-oberon07',
            ext: 'o7'
        });
    }
    startState () {
        return {
            indent: 0,
            scope: [],
            token: null
        };
    }
    _isAlpha (ch) {
        return /[a-zA-Z_]/.test(ch);
    }
    _ident (ch, stream) {
        let buf = [],
            tokens = [];
        buf.push(ch);
        ch = stream.peek();
        while (!stream.eof && this._isAlpha(ch)) {
            ch = stream.next();
            buf.push(ch);
            ch = stream.peek();
        }
        if (ch == '.' || ch == '[') {
            tokens.push('qualifier');
        } else {
            tokens.push('variable');
        }
        return {
            name: buf.join(''),
            token: tokens.join(' ')
        };
    }
    token (stream, state) {
        let result = { token: 'null' },
            ch = stream.next();
        if (this._isAlpha(ch)) {
            result = this._ident(ch, stream);
        }
        return result.token;
    }
    indent (state, textAfter) {
        let words = textAfter.split(' ');
        if (words[0] === 'END' && state.indent > 0) {  --state.indent; }
        return state.indent;
    }
    mode () {
        return {
            startState: this.startState,
            token: this.token,
            indent: this.indent
        }
    }
    validator (text, option) {
        return [];
    }
    register (CM) {
        CM.defineMIME(this.type, this.name);
        CM.defineMode(this.type, this.mode);
        CM.registerHelper('lint', this.name, this.validator);
    }
}
