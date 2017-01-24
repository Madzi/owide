import {FileHelper, IdeFile} from './files';
import {QFilter, QNAME, QMIME, QMODE, QHINT, QCONF} from './qcode';

class Node {
    static one (sel) { return document.querySelector(sel); }
    static all (sel) { return document.querySelectorAll(sel); }
}

let btnNew = Node.one('#btn-new'),
    btnOpen = Node.one('#btn-open'),
    btnSave = Node.one('#btn-save'),
    fileName = Node.one('#file-name'),
    codeArea = Node.one('#code-area'),
    theFile = new IdeFile(),
    codeEditor = CodeMirror.fromTextArea(codeArea, {
        theme: 'eclipse',
        identUnit: 4,
        lineNumbers: true,
        lineWrapping: true
    });

let resetEditor = function () {
    codeEditor.setValue('');
    codeEditor.clearHistory();
    fileName.innerHTML = '';
    //codeEditor.clearGutter("ID");
};

btnNew.addEventListener('click', e => {
    resetEditor();
    e.stopPropagation();
    e.preventDefault();
});

btnOpen.addEventListener('click', e => {
    FileHelper.open(function (ideFile) {
        fileName.innerHTML = ideFile.name;
        // check file type and decode
        codeEditor.setValue(ideFile.content);
    });
    e.stopPropagation();
    e.preventDefault();
});

btnSave.addEventListener('click', e => {
    theFile.content = codeEditor.getValue();
    // check file type and encode
    FileHelper.save(theFile);
    e.stopPropagation();
    e.preventDefault();
});

CodeMirror.defineMIME(QMIME, QCONF);
CodeMirror.defineMode(QNAME, QMODE);
CodeMirror.registerHelper('hintWords', QMIME, QHINT);
