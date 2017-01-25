let _encode = function (str, bufView) {
        for (let i = 0, len = str.length; i < len; ++i) {
            bufView[i] = str.charCodeAt(i);
        }
    };

let _decode = function (bufView) {
        let strBuf = [];
        for (let i = 0, len = bufView.length; i < len; ++i) {
            strBuf.push(String.fromCharCode(bufView[i]));
        }
        return strBuf.join('');
    };

export let encode8 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint8Array(buf));
        return buf;
    };

export let encode16 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint16Array(buf));
        return buf;
    };

export let encode32 = function (str) {
        let buf = new ArrayBuffer(str.length);
        _encode(str, new Uint32Array(buf));
        return buf;
    };

export let decode8 = function (buf) { return _decode(new Uint8Array(buf)); };

export let decode16 = function (buf) { return _decode(new Uint16Array(buf)); };

export let decode32 = function (buf) { return _decode(new Uint32Array(buf)); };

export let fileExt = function (name) {
    let parts = name.split('/').pop() || name;
    return parts.indexOf('.') > 0 ? parts.split('.').pop() : '';
};
