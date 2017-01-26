import LangServer from './lang-serv';
import {encode16, decode16} from './file-codecs';

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
        return tmp.join('\n');
    }
    saveFile (str) {
        return encode16(str);
    }
}
