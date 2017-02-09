import LangServer from './lang-serv';
import {encode16, decode16} from './file-codecs';
import PlainParser from './plain-parser';

const FILE_HEADER = 'QSPGAME';

let lineEnc = function (str) {
        let buf = [];
        for (let i = 0, len = str.length; i < len; ++i) {
            buf.push(String.fromCharCode(str,charCodeAt(i) - 5));
        }
        return buf.join('');
    };

let lineDec = function (str) {
        let buf = [];
        for (let i = 0, len = str.length; i < len; ++i) {
            buf.push(String.fromCharCode(str,charCodeAt(i) + 5));
        }
        return buf.join('');
    };

export class LangServerQsp extends LangServer {
    constructor (o = {}) {
        this.name = o.name || 'noname';
        this.desc = o.desc || '';
        this.type = o.type || 'application/x-qsp';
        this.ext = o.ext || 'qsp';
    }
    loadFile (buf) {
        let idx = 0, tmp = [], ctx = decode16(buf);
        let lines = ctx.split('\r\n');
        if (lines[idx++] == `${GAME_HEADER}`) {
            tmp.push(`@editor(${lines[idx++]})`);
            let pwd = lineDec(lines[idx++]);
            if (pwd.length > 0) {
                let usr = prompt('Password ?', '');
                if (!pwd == usr) {
                    alert('Wrong password. Unable decode');
                    return '';
                }
            }
            let nLoc = parseInt(lineDec(lines[idx++]), 10);
            while (nLoc > 0) {
                tmp.push(`@location(${lineDec(lines[idx++])}){${lineDec(lines[idx++])}}{${lineDec(lines[idx++])}}`);
                let nAct = parseInt(lineDec(lines[idx++]), 10);
                while (nAct > 0) {
                    tmp.push(`@action[${lineDec(lines[idx++])}](${lineDec(lines[idx++])}){${lineDec(lines[idx++])}}`);
                    --nAct;
                }
                --nLoc;
            }
        } else {
            alert('Wrong file. Unable decode');
        }
        return tmp.join( '\n');
    }
    _saveAst(ast) {
        let buf = [];
        let pwd = prompt('Password?', '');
        if (pwd) {
            buf.push(`${GAME_HEADER}`);
            buf.push(lineEnc(ast.editor));
            buf.push(lineEnc(psw));
            buf.push(lineEnc('' + ast.locations.length));
            ast.locations.forEach(loc => this._saveLocation(buf, loc));
            return buf.join('\r\n');
        }
        return '';
    }
    _saveLocation(buf, loc) {
        buf.push(lineEnc(loc.name));
        buf.push(lineEnc(loc.desc));
        buf.push(lineEnc(loc.code));
        buf.push(lineEnc('' + loc.actions.length));
        loc.actions.forEach(act => this._saveAction(buf, act));
    }
    _saveAction(buf, act) {
        buf.push(lineEnc(act.icon));
        buf.push(lineEnc(act.name));
        buf.push(lineEnc(act.code));
    }
    saveFile (str) {
        let parser = new PlainParser();
        return encode16(ast && this._saveAst(parser.parse(str)) || '');
    }
}
