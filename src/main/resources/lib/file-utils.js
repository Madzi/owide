(function (root) {
    'use strict';

    root.FileUtils = (function () {
        var _decode = function (bufView) {
                let strBuf = [];
                for (let i = 0, len = bufView.length; i < len; ++i) {
                    strBuf.push(String.fromCharCode(bufView[i]));
                }
                return strBuf.join('');
            },
            decode8 = function (buf) {
                return _decode(new Uint8Array(buf));
            },
            decode16 = function (buf) {
                return _decode(new Uint16Array(buf));
            },
            decode32 = function (buf) {
                return _decode(new Uint32Array(buf));
            },
            _encode = function (str, bufView) {
                for (let i = 0, len = str.length; i < len; ++i) {
                    bufView[i] = str.charCodeAt(i);
                }
            },
            encode8 = function (str) {
                let buf = new ArrayBuffer(str.length);
                _encode(str, new Uint8Array(buf));
                return buf;
            },
            encode16 = function (str) {
                let buf = new ArrayBuffer(str.length * 2);
                _encode(str, new Uint16Array(buf));
                return buf;
            },
            encode32 = function (str) {
                let buf = new ArrayBuffer(str.length * 4);
                _encode(str, new Uint32Array(buf));
                return buf;
            };

        return {
            encode8: encode8,
            decode8: decode8,
            encode16: encode16,
            decode16: decode16,
            encode32: encode32,
            decode32: decode32
        };
    })();

})(this);