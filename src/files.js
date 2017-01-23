export let FileHelper = (function () {
    let nOpen = document.createElement('input'),
        nSave = document.createElement('a'),
        knownExt = {},
        coders = {},
        oCallback = function (ideFile) {},
        register = function (type, encoder, decoder) {
            if (typeof type == 'string') {
                coders[type.toLowerCase()] = {
                    encode: encoder,
                    decode: decoder
                };
            }
        },
        forMIME = function (type = 'plain/text') {
            console.log(type);
            return coders[(type||'').toLowerCase()] || coders['plain/text'];
        },
        decode8 = function (buf) {
            let bufView = new Uint8Array(buf);
            let strBuf = [];
            for (let i = 0, len = bufView.length; i < len; ++i) {
                strBuf.push(String.fromCharCode(bufView[i]));
            }
            return strBuf.join('');
        },
        decode16 = function (buf) {
            let bufView = new Uint16Array(buf);
            let strBuf = [];
            for (let i = 0, len = bufView.length; i < len; ++i) {
                strBuf.push(String.fromCharCode(bufView[i]));
            }
            return strBuf.join('');
        },
        decode32 = function (buf) {
            let bufView = new Uint32Array(buf);
            let strBuf = [];
            for (let i = 0, len = bufView.length; i < len; ++i) {
                strBuf.push(String.fromCharCode(bufView[i]));
            }
            return strBuf.join('');
        },
        encode8 = function (str) {
            let buf = new ArrayBuffer(str.length);
            let bufView = new Uint8Array(buf);
            for (let i = 0, len = str.length; i < len; ++i) {
                bufView[i] = str.charCodeAt(i);
            }
            return buf;
        },
        encode16 = function (str) {
            let buf = new ArrayBuffer(str.length * 2);
            let bufView = new Uint8Array(buf);
            for (let i = 0, len = str.length; i < len; ++i) {
                bufView[i] = str.charCodeAt(i);
            }
            return buf;
        },
        encode32 = function (str) {
            let buf = new ArrayBuffer(str.length * 4);
            let bufView = new Uint8Array(buf);
            for (let i = 0, len = str.length; i < len; ++i) {
                bufView[i] = str.charCodeAt(i);
            }
            return buf;
        },
        fileExtension = function (fileName) {
            let parts = (fileName||'').split('/'),
                last = parts.length > 0 ? parts.pop() : '';
            return last.indexOf('.') > 0 ? last.split('.').pop() : last;
        };

    nOpen.style.display = 'none';
    nSave.style.display = 'none';

    nOpen.type = 'file';
    nOpen.addEventListener('change', ev => {
        let file = nOpen.files[0],
            reader = new FileReader();
        reader.addEventListener('load', e => {
            console.log(file);
            let type = file.type.length > 0 ? file.type : knownExt[fileExtension(file.name)]||'plain/text';
            console.log(type);
            oCallback(new IdeFile({
                name: file.name,
                size: file.size,
                type: type,
                content: forMIME(type).decode(e.target.result)
            }));
        });
        reader.readAsArrayBuffer(file);
    });

    document.querySelector('body').appendChild(nOpen);
    document.querySelector('body').appendChild(nSave);

    register('plain/text', encode8, decode8);

    ['txt', 'csv'].forEach(ext => knownExt[ext] = 'plain/text');

    return {
        open: function (callback) {
            oCallback = callback || function (ideFile) {};
            nOpen.click();
        },
        save: function (ideFile) {
            if (ideFile) {
                let data = forMIME(ideFile.type).encode(ideFile.content);
                nSave.setAttribute('href', `data:${ideFile.type};base64,${data}`);
                nSave.setAttribute('download', ideFile.name);
                n.click();
            }
        }
    };
})();


export class IdeFile {
    constructor (o = {}) {
        this.name = o.name || 'noname.txt';
        this.size = o.size || 0;
        this.type = o.type || 'plain/text';
        this.content = o.content || '';
    }
}

