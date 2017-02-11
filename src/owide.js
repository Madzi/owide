import IdeCore from './ide-core';
import {LangServer, LangServerOberon07} from './lang-serv';
import CodeMirror from 'codemirror';
import __1 from 'codemirror/addon/edit/closebrackets';
import __2 from 'codemirror/addon/fold/brace-fold';
import __3 from 'codemirror/addon/fold/comment-fold';
import __4 from 'codemirror/addon/fold/foldcode';
import __5 from 'codemirror/addon/fold/foldgutter';
import __6 from 'codemirror/addon/fold/indent-fold';
import __7 from 'codemirror/addon/hint/show-hint';
import __8 from 'codemirror/addon/hint/anyword-hint';
import __9 from 'codemirror/addon/lint/lint';
import __A from 'codemirror/addon/lint/json-lint';

// tokens: 
//      keyword,        atom,           number,         def,
//      variable,       variable-2,     property,       operator,
//      comment,        string,         string-2,       meta,
//      error,          qualifier,      bultin,         bracket,
//      tag,            attribute,      header,         quote,
//      hr,             link

const OBJ = { KEYWORD: 'keyword', PREDEFINED: 'predefined', SYSTEM: 'system' };
/*
CodeMirror.defineMode("oberon07", function () {

var OBERON = (function () {
    let _symbols = {
            NULL:       0,  TIMES:      1,  SLASH:   2,  DIV:     3,  MOD:      4,
            AND:        5,  PLUS:       6,  MINUS:   7,  OR:      8,  EQL:      9,
            NEQ:       10,  LSS:       11,  LEQ:    12,  GTR:    13,  GEQ:     14,
            IN:        15,  IS:        16,  ARROW:  17,  PERIOD: 18,  COMMA:   19,
            COLON:     20,  UPTO:      21,  RPAREN: 22,  RBRAK:  23,  RBRACE:  24,
            OF:        25,  THEN:      26,  DO:     27,  TO:     28,  BY:      29,
            LPAREN:    30,  LBRAK:     31,  LBRACE: 32,  NOT:    33,  BECOMES: 34,
            NUMBER:    35,  NIL:       36,  TRUE:   37,  FALSE:  38,  STRING:  39,
            IDENT:     40,  SEMICOLON: 41,  BAR:    42,  END:    43,  ELSE:    44,
            ELSIF:     45,  UNTIL:     46,  IF:     47,  CASE:   48,  WHILE:   49,
            REPEAT:    50,  FOR:       51,  LOOP:   52,  WITH:   53,  EXIT:    54,
            RETURN:    55,  ARRAY:     56,  OBJECT: 57,  RECORD: 58,  POINTER: 59,
            BEGIN:     60,  CODE:      61,  CONST:  62,  TYPE:   63,  VAR:     64,
            PROCEDURE: 65,  IMPORT:    66,  MODULE: 67,  EOF:    68,  ERROR:   69
        };
    let genToken = function (sym, type, name, css) {
            return { sym: sym, type: type, name: name, css: css };
        };
    let _words = {};
    'ABS ASR ASSERT CHR COPY DEC EXCL FLOOR FLT INC INCL LEN LSL LOGN NEW ODD ORD PACK ROR SHORT UNPK'.split(' ').forEach(w => {
            _words[w] = genToken(_symbols.IDENT, OBJ.PREDEFINED, w, 'def');
        });
    'BOOLEAN CHAR INTEGER LONGREAL REAL SET'.split(' ').forEach(w => {
            _words[w] = genToken(_symbols.IDENT, OBJ.PREDEFINED, w, 'type');
        });
    'ADR SIZE BIT GET PUT'.split(' ').forEach(w => {
            _words[w] = genToken(_symbols.IDENT, OBJ.SYSTEM, w, 'atom');
        });
    _words['ARRAY'] = genToken(_symbols.ARRAY, OBJ.KEYWORD, 'ARRAY', 'keyword');
    _words['BEGIN'] = genToken(_symbols.BEGIN, OBJ.KEYWORD, 'BEGIN', 'keyword');
    _words['BY'] = genToken(_symbols.BY, OBJ.KEYWORD, 'BY', 'keyword');
    _words['CASE'] = genToken(_symbols.CASE, OBJ.KEYWORD, 'CASE', 'keyword');
    _words['CONST'] = genToken(_symbols.CONST, OBJ.KEYWORD, 'CONST', 'keyword');
    _words['DIV'] = genToken(_symbols.DIV, OBJ.KEYWORD, 'DIV', 'keyword');
    _words['DO'] = genToken(_symbols.DO, OBJ.KEYWORD, 'DO', 'keyword');
    _words['ELSE'] = genToken(_symbols.ELSE, OBJ.KEYWORD, 'ELSE', 'keyword');
    _words['ELSIF'] = genToken(_symbols.ELSIF, OBJ.KEYWORD, 'ELSIF', 'keyword');
    _words['END'] = genToken(_symbols.END, OBJ.KEYWORD, 'END', 'keyword');
    _words['FALSE'] = genToken(_symbols.FALSE, OBJ.KEYWORD, 'FALSE', 'keyword');
    _words['FOR'] = genToken(_symbols.FOR, OBJ.KEYWORD, 'FOR', 'keyword');
    _words['IF'] = genToken(_symbols.IF, OBJ.KEYWORD, 'IF', 'keyword');
    _words['IMPORT'] = genToken(_symbols.IMPORT, OBJ.KEYWORD, 'IMPORT', 'keyword');
    _words['IN'] = genToken(_symbols.IN, OBJ.KEYWORD, 'IN', 'keyword');
    _words['IS'] = genToken(_symbols.IS, OBJ.KEYWORD, 'IS', 'keyword');
    _words['MOD'] = genToken(_symbols.MOD, OBJ.KEYWORD, 'MOD', 'keyword');
    _words['MODULE'] = genToken(_symbols.MODULE, OBJ.KEYWORD, 'MODULE', 'keyword');
    _words['NIL'] = genToken(_symbols.NIL, OBJ.KEYWORD, 'NIL', 'keyword');
    _words['OF'] = genToken(_symbols.OF, OBJ.KEYWORD, 'OF', 'keyword');
    _words['OR'] = genToken(_symbols.OR, OBJ.KEYWORD, 'OR', 'keyword');
    _words['POINTER'] = genToken(_symbols.POINTER, OBJ.KEYWORD, 'POINTER', 'keyword');
    _words['PROCEDURE'] = genToken(_symbols.PROCEDURE, OBJ.KEYWORD, 'PROCEDURE', 'keyword');
    _words['RECORD'] = genToken(_symbols.RECORD, OBJ.KEYWORD, 'RECORD', 'keyword');
    _words['REPEAT'] = genToken(_symbols.REPEAT, OBJ.KEYWORD, 'REPEAT', 'keyword');
    _words['RETURN'] = genToken(_symbols.RETURN, OBJ.KEYWORD, 'RETURN', 'keyword');
    _words['THEN'] = genToken(_symbols.THEN, OBJ.KEYWORD, 'THEN', 'keyword');
    _words['TO'] = genToken(_symbols.TO, OBJ.KEYWORD, 'TO', 'keyword');
    _words['TRUE'] = genToken(_symbols.TRUE, OBJ.KEYWORD, 'TRUE', 'keyword');
    _words['TYPE'] = genToken(_symbols.TYPE, OBJ.KEYWORD, 'TYPE', 'keyword');
    _words['UNTIL'] = genToken(_symbols.UNTIL, OBJ.KEYWORD, 'UNIL', 'keyword');
    _words['VAR'] = genToken(_symbols.VAR, OBJ.KEYWORD, 'VAR', 'keyword');
    _words['WHILE'] = genToken(_symbols.WHILE, OBJ.KEYWORD, 'WHILE', 'keyword');

    return { Symbol: _symbols, Words: _words };
})(),
        _words = OBERON.Words,

        _isAlpha = function (ch) {
            return /[a-zA-Z_]/.test(ch);
        },

        _isAlphaOrDigit = function (ch) {
            return /[0-9a-zA-Z_]/.test(ch);
        },

        _token = function (stream, state) {
            var _state = state.state,

                _ident = function (sym) {
                    var _word,
                        _token = 'variable',
                        _str = sym,
                        _ch = stream.next();

                    while (_ch && _isAlphaOrDigit(_ch) && !stream.eol()) {
                        _str += _ch;
                        _ch = stream.next();
                    }
                    if (_isAlphaOrDigit(_ch)) {
                        _str += _ch;
                    }

                    state.name = _str;
                    if (_ch === '.' || _ch === '[') {
                        _token = 'variable qualifier';
                    }

                    _word = OBERON.Words[_str];

                    if (_word) {
                        switch (_word.name) {
                            case 'MODULE':
                            case 'PROCEDURE':
                            case 'IF':
                            case 'FOR':
                            case 'WHILE':
                                state.scope += 1;
                                break;
                            default:
                        }
                        _token = _word.css;
                    }

                    if (!stream.eol()) {
                        stream.backUp(1);
                    }

                    return _token;
                },

                _number = function () {},

                _string = function (sym) {
                    var _str,
                        _ch = stream.next();

                    while (_ch && _ch != sym && !stream.eol()) {
                        _str += _ch;
                        _ch = stream.next();
                    }
                    if (stream.eol() && _ch != sym) {
                        state.error = 'string.not.close';
                        return 'string error';
                    }
                    state.name = _str;
                    return 'string';
                },

                _comment = function () {
                    var mode = '?',
                        _ch;

                    while (state.level > 0 && !stream.eol()) {
                        _ch = stream.next();
                        switch (_ch) {
                            case '(':
                                mode = '(';
                                break;

                            case '*':
                                if (mode === '(') {
                                    state.level += 1;
                                }
                                mode = '*';
                                break;

                            case ')':
                                if (mode === '*') {
                                    state.level -= 1;
                                }
                                mode = ')';
                                break;

                            default:
                                mode = '?';
                        }
                        if (mode !== ')') {
                            state.error = 'unclosed.comment';
                            return 'comment error';
                        }
                    }
                    return 'comment';
                },

                _ch = stream.next();

            if (state.level > 0) {
                return _comment();
            }

            if (_isAlpha(_ch)) {
                return _ident(_ch);
            }

            switch (_ch) {
                case '"':
                case "'":
                    return _string(_ch);

                case '[':
                case ']':
                case '{':
                case '}':
                case ')':
                    return 'bracket';

                case '(':
                    if (stream.peek() === '*') {
                        state.level += 1;
                        return _comment();
                    }
                    return 'bracket';

                case ':':
                    if (stream.peek() === '=') {
                        _ch = stream.next();
                        return 'keyword';
                    }
                    return 'operator';

                case '<':
                case '>':

                case '#':
                case '&':
                case '+':
                case '-':
                case '*':
                case '/':
                case '~':
                case '|':
                case '^':
                case ',':
                case ';':
                    return 'operator';
            }

            return null;
        };

    return {
        startState: function () {
            return {
                indent: 0,
                stack: [],
                state: null,
                ch: null,
                scope: 'rtl',
                level: 0,
                error: null,
                name: null,
            };
        },

        token: _token,
        indent: (state, textAfter) => {
            let words = textAfter.split(' ');
            if (words[0] === 'END' && state.indent > 0) {
                state.indent--;
            }
            return state.indent;
        }
    };

});
*/


let oberonLang = new LangServerOberon07();
oberonLang.register(CodeMirror);

let ideCore = new IdeCore();
let codeArea = document.querySelector('#code-area');
let codeEditor = CodeMirror.fromTextArea(codeArea, {
        value: ['one twom three'],
        lineNumbers: true,
        autoCloseBrackets: true,
        foldGutter: true,
        gutters: ['breakpoints', 'CodeMirror-linenumbers', 'CodeMirror-foldgutter'],
        extraKeys: {'Ctrl-Space': 'autocomplete'},
        mode: 'text/x-oberon07'
    });

codeEditor.foldCode(CodeMirror.Pos(0, 0));

let makeMarker = function () {
  var marker = document.createElement("div");
  marker.style.color = "#822";
  marker.innerHTML = "●";
  return marker;
}

codeEditor.on("gutterClick", (cm, n) => {
    var info = cm.lineInfo(n);
    cm.setGutterMarker(n, "breakpoints", info.gutterMarkers ? null : makeMarker());
});

/* Add events to menu */
document.querySelector('#menu-item-new').addEventListener('click', e => {
    ideCore.fileNew();
    codeEditor.setValue('');
    codeEditor.clearHistory();
});

document.querySelector('#menu-item-open').addEventListener('click', e => {
    ideCore.fileOpen();
});

document.querySelector('#menu-item-save').addEventListener('click', e => {
    ideCore.fileSave();
});

ideCore.registerLoadCallback(function (str) {
    codeEditor.setValue(str);
    codeEditor.clearHistory();
});


//window.addEventListener('load', (event) => {
//});
