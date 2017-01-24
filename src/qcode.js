/*
CodeMirror CSS styles:
- meta      - keyword       - atom          - number        - def
- variable  - variable-2    - variable-3    - property      - operator
- comment   - string        - string-2      - qualifier     - builtin
- bracket   - tag           - attribute     - link          - error
*/


export const QNAME = 'qsp';
export const HEADER = 'QSPGAME';
export const KEYWORDS = 'ACT ADDLIB ADDOBJ ADDQST AND ARRCOMP ARRPOS ARRSIZE'
        + ' $BACKIMAGE BCOLOR'
        + ' CLA CLEAR *CLEAR CLOSE CLR *CLR CLS CMDCLEAR CMDCLR COPYARR $COUNTER COUNTOBJ $CURACTS CURLOC'
        + ' DEBUG DELACT DELLIB DELOBJ DESC DISABLESCROLL DISABLESUBEX DYNAMIC DYNEVAL'
        + ' ELSE ELSEIF EXIT'
        + ' FCOLOR $FNAME FREELIB FSIZE FUNC'
        + ' GETOBJ GOSUB GOTO GS GT'
        + ' IF IIF INCLIB INPUT INSTR ISNUM ISPLAY'
        + ' JUMP'
        + ' KILLALL KILLOBJ KILLQST KILLVAR'
        + ' LCASE LCOLOR LEN LET LOC'
        + ' $MAINTXT MAX MENU MID MIN MOD MSECSCOUNT MSG'
        + ' NL *NL NO NOSAVE'
        + ' OBJ $ONACTSEL $ONGLOAD $ONGSAVE $ONNEWLOC $ONOBJADD $ONOBJDEL $ONOBJSEL OPENGAME OPENQST OR'
        + ' P *P PL *PL PLAY'
        + ' QSPVER'
        + ' RAND REFINT REPLACE RGB RND'
        + ' SAVEGAME SELACT SELOBJ SET SETTIMER SHOWACTS SHOWINPUT SHOWOBJS SHOWSTAT $STATTXT STR STRCOMP STRFIND STRPOS TRIM UCASE UNSEL UNSELECT USEHTML $USERCOM USER_TEXT USRTXT VAL VIEW WAIT'
        + ' XGOTO XGT';

export const QMIME = `application/x-${QNAME}`;

export let QCONF = {
};

export let QMODE = function (config, parserConfig) {
    return {
        startState: function (baseColumn) {
            return {
                stack: 0,
                scope: 'out', // out - author - loc-name - loc-desc - loc-code - act-img - act-name - act-code
            };
        },
        token: function (stream, state) {
            stream.next();
            return 'string';
        }
//        indent: function (state, textAfter) {}
    };
};

export let QHINT = ['ABS'];

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
            let lines = ctx.split('\r\n');
            if (lines[idx++] == `${HEADER}`) {
                buf.push(`@editor(${lines[idx++]})`);
                let pwd = _dec(lines[idx++]);
                // let usr = window.prompt('P', '');
                if (pwd == pwd) {
                    let nLoc = parseInt(_dec(lines[idx++]), 10);
                    while (nLoc > 0) {
                        buf.push(`@loc(${_dec(lines[idx++])}){${_dec(lines[idx++])}}{${_dec(lines[idx++])}}`);
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
