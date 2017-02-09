import Stream from './stream';

export class PlainScanner {
    constructor () {}
    _newToken (stream) {
        return {
            type: 'error',
            name: 'empty file',
            begin: stream.pos,
            end: stream.pos
        };
    }
    scan (str) {
        let stream = new Stream();
        let tokens = [];
        let token = this._newToken(stream);
        let ch = stream.next();
        while (ch) {
            switch (ch) {
                case '@':
                    token.type = 'at';
                    token.name =  '@';
                    token.end = stream.pos;
                    tokens.push(token);
                    token.type = this._newToken(stream);
                    break;
                case '0..9':
                    break;
                default:
                    tokens.push(this._newToken(stream));
                    break;
            }
            ch = stream.next();
        }
        return tokens;
    }
}

const KNOWN_WORdS = {
    LET: 'keyword'
};

let isAplha = function (ch) {
    return /а-яА-ЯёЁa-zA-Z/.test(ch);
};

let isDigit = function (ch)

let ident = function (stream) {
    let word = '';
    let ch = stream.next();
    while (/[a-zA-Z_]/.test(ch)) {
        word += ch;
        ch = stream.next();
    }
    return {};
}

export class PlainParser {
    constructor () {
        this.scanner = new PlainScanner();
    }
    parse (str) {
        let tokens = this.scanner.scan(str);
        let ast = {
            editor: 'OWIDE v 0.0.1',
            locations: []
        };
        let idx = 0;
        while (idx < tokens.length && tokens[idx].type != 'error') {
            idx++;
        }
        if (tokens[idx].type == 'error') {
            ast = null;
        }
        return ast;
    }
}
