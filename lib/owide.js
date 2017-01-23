/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _files = __webpack_require__(1);

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	var Node = function () {
	    function Node() {
	        _classCallCheck(this, Node);
	    }

	    _createClass(Node, null, [{
	        key: 'one',
	        value: function one(sel) {
	            return document.querySelector(sel);
	        }
	    }, {
	        key: 'all',
	        value: function all(sel) {
	            return document.querySelectorAll(sel);
	        }
	    }]);

	    return Node;
	}();

	var btnNew = Node.one('#btn-new'),
	    btnOpen = Node.one('#btn-open'),
	    btnSave = Node.one('#btn-save'),
	    fileName = Node.one('#file-name'),
	    codeArea = Node.one('#code-area'),
	    theFile = new _files.IdeFile(),
	    codeEditor = CodeMirror.fromTextArea(codeArea, {
	    lineNumbers: true
	});

	var resetEditor = function resetEditor() {
	    codeEditor.setValue('');
	    codeEditor.clearHistory();
	    fileName.innerHTML = '';
	    //codeEditor.clearGutter("ID");
	};

	btnNew.addEventListener('click', function (e) {
	    resetEditor();
	    e.stopPropagation();
	    e.preventDefault();
	});

	btnOpen.addEventListener('click', function (e) {
	    _files.FileHelper.open(function (ideFile) {
	        fileName.innerHTML = ideFile.name;
	        codeEditor.setValue(ideFile.content);
	    });
	    e.stopPropagation();
	    e.preventDefault();
	});

	btnSave.addEventListener('click', function (e) {
	    theFile.content = codeEditor.getValue();
	    _files.FileHelper.save(theFile);
	    e.stopPropagation();
	    e.preventDefault();
	});

	var words = function words(str) {
	    var o = {},
	        war = str.split(' ') || [];
	    (str.split(' ') || []).forEach(function (w) {
	        return o[w] = !!1;
	    });
	    return o;
	};

	// CodeMirror.defineMIME(`text/x-${MODE_NAME}`, {
	//     name: MODE_NAME,
	//     keywords: words(''),
	//     blockKeyworsd: words(''),
	//     builtin: words(''),
	//     atoms: words('')
	// });

	// CodeMirror.defineMode(MODE_NAME, function (config, parserConfig) {});

/***/ },
/* 1 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	var FileHelper = exports.FileHelper = function () {
	    var nOpen = document.createElement('input'),
	        nSave = document.createElement('a'),
	        knownExt = {},
	        coders = {},
	        oCallback = function oCallback(ideFile) {},
	        register = function register(type, encoder, decoder) {
	        if (typeof type == 'string') {
	            coders[type.toLowerCase()] = {
	                encode: encoder,
	                decode: decoder
	            };
	        }
	    },
	        forMIME = function forMIME() {
	        var type = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'plain/text';

	        console.log(type);
	        return coders[(type || '').toLowerCase()] || coders['plain/text'];
	    },
	        _decode = function _decode(bufView) {
	        var strBuf = [];
	        for (var i = 0, len = bufView.length; i < len; ++i) {
	            strBuf.push(String.fromCharCode(bufView[i]));
	        }
	        return strBuf.join('');
	    },
	        decode8 = function decode8(buf) {
	        return _decode(new Uint8Array(buf));
	    },
	        decode16 = function decode16(buf) {
	        return _decode(new Uint16Array(buf));
	    },
	        decode32 = function decode32(buf) {
	        return _decode(new Uint32Array(buf));
	    },
	        _encode = function _encode(str, bufView) {
	        for (var i = 0, len = str.length; i < len; ++i) {
	            bufView[i] = str.charCodeAt(i);
	        }
	    },
	        encode8 = function encode8(str) {
	        var buf = new ArrayBuffer(str.length);
	        _encode(str, new Uint8Array(buf));
	        return buf;
	    },
	        encode16 = function encode16(str) {
	        var buf = new ArrayBuffer(str.length * 2);
	        _encode(str, new Uint16Array(buf));
	        return buf;
	    },
	        encode32 = function encode32(str) {
	        var buf = new ArrayBuffer(str.length * 4);
	        _encode(str, new Uint32Array(buf));
	        return buf;
	    },
	        fileExtension = function fileExtension(fileName) {
	        var parts = (fileName || '').split('/'),
	            last = parts.length > 0 ? parts.pop() : '';
	        return last.indexOf('.') > 0 ? last.split('.').pop() : last;
	    };

	    nOpen.style.display = 'none';
	    nSave.style.display = 'none';

	    nOpen.type = 'file';
	    nOpen.addEventListener('change', function (ev) {
	        var file = nOpen.files[0],
	            reader = new FileReader();
	        reader.addEventListener('load', function (e) {
	            console.log(file);
	            var type = file.type.length > 0 ? file.type : knownExt[fileExtension(file.name)] || 'plain/text';
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

	    ['txt', 'csv'].forEach(function (ext) {
	        return knownExt[ext] = 'plain/text';
	    });

	    return {
	        open: function open(callback) {
	            oCallback = callback || function (ideFile) {};
	            nOpen.click();
	        },
	        save: function save(ideFile) {
	            if (ideFile) {
	                var data = forMIME(ideFile.type).encode(ideFile.content);
	                nSave.setAttribute('href', 'data:' + ideFile.type + ';base64,' + data);
	                nSave.setAttribute('download', ideFile.name);
	                n.click();
	            }
	        }
	    };
	}();

	var IdeFile = exports.IdeFile = function IdeFile() {
	    var o = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

	    _classCallCheck(this, IdeFile);

	    this.name = o.name || 'noname.txt';
	    this.size = o.size || 0;
	    this.type = o.type || 'plain/text';
	    this.content = o.content || '';
	};

/***/ }
/******/ ]);