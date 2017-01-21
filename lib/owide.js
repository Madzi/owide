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
	    fileLoader = new _files.FileLoader(),
	    codeArea = Node.one('#code-area'),
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
	    fileLoader.load(function (data) {
	        var content = data.content.byteLength % 2 == 1 ? new Uint8Array(data.content) : new UInt16Array(data.content);
	        fileName.innerHTML = data.name;
	        codeEditor.setValue(new TextDecoder('utf-8').decode(data.content));
	    });
	    e.stopPropagation();
	    e.preventDefault();
	});

	btnSave.addEventListener('click', function (e) {
	    fileLoader.save(fileName.innerHTML, codeEditor.getValue());
	    console.log('TOOLS:SAVE');
	    e.stopPropagation();
	    e.preventDefault();
	});

/***/ },
/* 1 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	var FileLoader = exports.FileLoader = function () {
	    function FileLoader() {
	        var _this = this;

	        _classCallCheck(this, FileLoader);

	        this.fileInput = document.createElement('input');
	        this.fileInput.type = 'file';
	        this.fileInput.style.display = 'none';
	        document.querySelector('body').appendChild(this.fileInput);
	        this.fileInput.addEventListener('change', function (ev) {
	            var file = _this.fileInput.files[0],
	                reader = new FileReader();
	            reader.addEventListener('load', function (e) {
	                if (_this.callback) {
	                    _this.callback({
	                        name: file.name,
	                        content: e.target.result
	                    });
	                }
	            });
	            reader.readAsArrayBuffer(file);
	        });
	        this.fileOutput = document.createElement('a');
	        this.fileOutput.style.display = 'none';
	        document.querySelector('body').appendChild(this.fileOutput);
	    }

	    _createClass(FileLoader, [{
	        key: 'load',
	        value: function load(callback) {
	            this.callback = callback;
	            this.fileInput.click();
	        }
	    }, {
	        key: 'save',
	        value: function save(fileName, data) {
	            this.fileOutput.setAttribute('href', 'data:text/plain;base64,' + btoa(data));
	            this.fileOutput.setAttribute('download', fileName);
	            this.fileOutput.click();
	        }
	    }, {
	        key: 'extension',
	        value: function extension(fileName) {
	            return (parts = fileName.split('/').pop().split('.')).length > 1 ? parts.pop() : "";
	        }
	    }]);

	    return FileLoader;
	}();

/***/ }
/******/ ]);