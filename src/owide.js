import IdeCore from './ide-core';
import CodeMirror from 'codemirror';

const CSS = {
        KEYWORD: 'keyword', ATOM: 'atom', NUMBER: 'number', DEF: 'def', VARIABLE: 'variable', VARIABLE_2: 'variable-2',
        PROPERTY: 'property', OPERATOR: 'operator', COMMENT: 'comment', STRING: 'string', STRING_2: 'string-2', META: 'meta',
        ERROR: 'error', QUALIFIER: 'qualifier', BUILTIN: 'builtin', BRACKET: 'bracket', TAG: 'tag', ATTRIBUTE: 'attribute',
        HEADER: 'header', QUOTE: 'quote', HR: 'hr', LINK: 'link'
    };

const ED = {
        DEF: CSS.DEF, TYPE: CSS.ATOM, CHAR: CSS.STRING_2, SYSTEM: CSS.META, IDENT: CSS.VARIABLE, ERROR: CSS.ERROR, STRING: CSS.STRING,
        COMMENT: CSS.COMMENT, BRACKET: CSS.BRACKET, KEYWORD: CSS.KEYWORD, OPERATOR: CSS.OPERATOR, QUALIFIER: CSS.QUALIFIER
};

const OBJ = { KEYWORD: 'keyword', PREDEFINED: 'predefined', SYSTEM: 'system' };

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
            _words[w] = genToken(_symbols.IDENT, OBJ.PREDEFINED, w, ED.DEF);
        });
    'BOOLEAN CHAR INTEGER LONGREAL REAL SET'.split(' ').forEach(w => {
            _words[w] = genToken(_symbols.IDENT, OBJ.PREDEFINED, w, ED.TYPE);
        });
    'ADR SIZE BIT GET PUT'.split(' ').forEach(w => {
            _words[w] = genToken(_symbols.IDENT, OBJ.SYSTEM, w, ED.SYSTEM);
        });
    _words['ARRAY'] = genToken(_symbols.ARRAY, OBJ.KEYWORD, 'ARRAY', ED.KEYWORD);
    _words['BEGIN'] = genToken(_symbols.BEGIN, OBJ.KEYWORD, 'BEGIN', ED.KEYWORD);
    _words['BY'] = genToken(_symbols.BY, OBJ.KEYWORD, 'BY', ED.KEYWORD);
    _words['CASE'] = genToken(_symbols.CASE, OBJ.KEYWORD, 'CASE', ED.KEYWORD);
    _words['CONST'] = genToken(_symbols.CONST, OBJ.KEYWORD, 'CONST', ED.KEYWORD);
    _words['DIV'] = genToken(_symbols.DIV, OBJ.KEYWORD, 'DIV', ED.KEYWORD);
    _words['DO'] = genToken(_symbols.DO, OBJ.KEYWORD, 'DO', ED.KEYWORD);
    _words['ELSE'] = genToken(_symbols.ELSE, OBJ.KEYWORD, 'ELSE', ED.KEYWORD);
    _words['ELSIF'] = genToken(_symbols.ELSIF, OBJ.KEYWORD, 'ELSIF', ED.KEYWORD);
    _words['END'] = genToken(_symbols.END, OBJ.KEYWORD, 'END', ED.KEYWORD);
    _words['FALSE'] = genToken(_symbols.FALSE, OBJ.KEYWORD, 'FALSE', ED.KEYWORD);
    _words['FOR'] = genToken(_symbols.FOR, OBJ.KEYWORD, 'FOR', ED.KEYWORD);
    _words['IF'] = genToken(_symbols.IF, OBJ.KEYWORD, 'IF', ED.KEYWORD);
    _words['IMPORT'] = genToken(_symbols.IMPORT, OBJ.KEYWORD, 'IMPORT', ED.KEYWORD);
    _words['IN'] = genToken(_symbols.IN, OBJ.KEYWORD, 'IN', ED.KEYWORD);
    _words['IS'] = genToken(_symbols.IS, OBJ.KEYWORD, 'IS', ED.KEYWORD);
    _words['MOD'] = genToken(_symbols.MOD, OBJ.KEYWORD, 'MOD', ED.KEYWORD);
    _words['MODULE'] = genToken(_symbols.MODULE, OBJ.KEYWORD, 'MODULE', ED.KEYWORD);
    _words['NIL'] = genToken(_symbols.NIL, OBJ.KEYWORD, 'NIL', ED.KEYWORD);
    _words['OF'] = genToken(_symbols.OF, OBJ.KEYWORD, 'OF', ED.KEYWORD);
    _words['OR'] = genToken(_symbols.OR, OBJ.KEYWORD, 'OR', ED.KEYWORD);
    _words['POINTER'] = genToken(_symbols.POINTER, OBJ.KEYWORD, 'POINTER', ED.KEYWORD);
    _words['PROCEDURE'] = genToken(_symbols.PROCEDURE, OBJ.KEYWORD, 'PROCEDURE', ED.KEYWORD);
    _words['RECORD'] = genToken(_symbols.RECORD, OBJ.KEYWORD, 'RECORD', ED.KEYWORD);
    _words['REPEAT'] = genToken(_symbols.REPEAT, OBJ.KEYWORD, 'REPEAT', ED.KEYWORD);
    _words['RETURN'] = genToken(_symbols.RETURN, OBJ.KEYWORD, 'RETURN', ED.KEYWORD);
    _words['THEN'] = genToken(_symbols.THEN, OBJ.KEYWORD, 'THEN', ED.KEYWORD);
    _words['TO'] = genToken(_symbols.TO, OBJ.KEYWORD, 'TO', ED.KEYWORD);
    _words['TRUE'] = genToken(_symbols.TRUE, OBJ.KEYWORD, 'TRUE', ED.KEYWORD);
    _words['TYPE'] = genToken(_symbols.TYPE, OBJ.KEYWORD, 'TYPE', ED.KEYWORD);
    _words['UNTIL'] = genToken(_symbols.UNTIL, OBJ.KEYWORD, 'UNIL', ED.KEYWORD);
    _words['VAR'] = genToken(_symbols.VAR, OBJ.KEYWORD, 'VAR', ED.KEYWORD);
    _words['WHILE'] = genToken(_symbols.WHILE, OBJ.KEYWORD, 'WHILE', ED.KEYWORD);

    return { Symbol: _symbols, Words: _words };
})(),
        _words = OBERON.Words,

        _isAlpha = function (ch) {
            return /[a-zA-Z_]/.test(ch);
        },

        _isAlphaOrDigit = function (ch) {
            return /[0-9a-zA-Z_]/.test(ch);
        },

        _startState = function () {
            return {
                stack: [],
                state: null,
                ch: null,
                scope: 0,
                level: 0,
                error: null,
                name: null,
            };
        },

        _token = function (stream, state) {
            var _state = state.state,

                _ident = function (sym) {
                    var _word,
                        _token = ED.IDENT,
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
                        _token = ED.QUALIFIER;
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
                        return ED.ERROR;
                    }
                    state.name = _str;
                    return ED.STRING;
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
                    }
                    return ED.COMMENT;
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
                    return ED.BRACKET;

                case '(':
                    if (stream.peek() === '*') {
                        state.level += 1;
                        return _comment();
                    }
                    return ED.BRACKET;

                case ':':
                    if (stream.peek() === '=') {
                        _ch = stream.next();
                        return ED.KEYWORD;
                    }
                    return ED.OPERATOR;

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
                    return ED.OPERATOR;
            }

            return null;
        };

    return {
        startState: _startState,
        token: _token,
        indent: (state, textAfter) => {
            let words = textAfter.split(' ');
            if (words[0] === 'END' && stage.scope > 0) {
                stage.scope--;
            }
            return stage.scope;
        }
    };

});

CodeMirror.defineMIME("text/x-oberon07", "oberon07");


class LanguegeServerO7 {
    constructor () {}
}

let ideCore = new IdeCore();
let codeArea = document.querySelector('#code-area');
let codeEditor = CodeMirror.fromTextArea(codeArea, {
        lineNumbers: true,
        mode: 'text/x-oberon07'
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
