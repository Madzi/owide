export let QFilter = (function () {
    let _enc = function (str) {
            let buf = [];
            for (let i = 0, len = str.length; i < len; ++i) {
                buf.push(String.fromCharCode(str.charCodeAt(i) - 5));
            }
            return buf.join('');
        },
        _dec = function (str) {
            let buf = [];
            for (let i = 0, len = str.length; i < len; ++i) {
                buf.push(String.fromCharCode(str.charCodeAt(i) + 5));
            }
            return buf.join('');
        };
    return {
        encode: function (ctx) {
            return ctx;
        },
        decode: function (ctx) {
            let idx = 0, buf = [];
            let lines = ctx.split('\n');
            if (lines[idx++] == `${HEADER}`) {
                buf.push(`@editor(${lines[idx++]})`);
                pwd = _dec(lines[idx++]);
                usr = window.prompt('P', '');
                if (usr == pwd) {
                    let nLoc = parseInt(_dec(lines[idx++]), 10);
                    while (nLoc > 0) {
                        buf.push(`@loc(${_dec(lines[idx++])}){${_dec(_lines[idx++])}}{${_dec(lines[idx++])}}`);
                        let nAct = parseInt(_dec(lines[idx++]), 10);
                        while (nAct > 0) {
                            buf.push(`@act[${_dec(lines[idx++])}](${_dec(lines[idx++])}){${_dec(lines[idx++])}}`);
                            nAct--;
                        }
                        nLoc--;
                    }
                } else {
                    buf = [];
                }
            } else {
                buf = lines;
            }
            return buf.join('\n');
        }
    };
})();
