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
/***/ function(module, exports) {

	'use strict';

	// class Node {
	//     static one (sel) { return document.querySelector(sel); }
	//     static all (sel) { return document.querySelectorAll(sel); }
	// }

	// let codeArea = Node.one('#code-area'),
	//     codeEditor = CodeMirror.fromTextArea(codeArea, {
	//         lineNumbers: true
	//     });

	webix.ui({
	    view: 'layout',
	    rows: [{
	        type: 'clean',
	        cols: [{
	            view: 'menu',
	            data: [{
	                id: 1,
	                value: 'File',
	                submenu: ['New', 'Open', 'Save']
	            }],
	            css: 'blue'
	        }]
	    }, {
	        cols: [{
	            id: 'f',
	            view: 'tree',
	            data: [{ value: 'f01' }, { value: 'f02' }, { value: 'f03' }, { value: 'f04' }, { value: 'f05' }, { value: 'f06' }, { value: 'f07' }, { value: 'f08' }, { value: 'f09' }, { value: 'f10' }, { value: 'f11' }, { value: 'f12' }, { value: 'f13' }, { value: 'f14' }, { value: 'f15' }, { value: 'f16' }, { value: 'f17' }, { value: 'f18' }, { value: 'f19' }, { value: 'f20' }, { value: 'f21' }],
	            width: 200
	        }, {
	            view: 'resizer'
	        }, {
	            id: 'e'
	        }]
	    }, {
	        view: 'resizer'
	    }, {
	        id: 'c',
	        view: 'list',
	        data: ['Line - 01', 'Line - 02', 'Line - 03', 'Line - 04', 'Line - 05', 'Line - 06', 'Line - 07', 'Line - 08'],
	        height: 100
	    }]
	});

/***/ }
/******/ ]);