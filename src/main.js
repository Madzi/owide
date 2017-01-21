import {FileLoader} from './files';

class Node {
    static one (sel) { return document.querySelector(sel); }
    static all (sel) { return document.querySelectorAll(sel); }
}

let btnNew = Node.one('#btn-new'),
    btnOpen = Node.one('#btn-open'),
    btnSave = Node.one('#btn-save'),
    fileName = Node.one('#file-name'),
    fileLoader = new FileLoader(),
    codeArea = Node.one('#code-area'),
    codeEditor = CodeMirror.fromTextArea(codeArea, {
        lineNumbers: true
    });

let resetEditor = function () {
    codeEditor.setValue('');
    codeEditor.clearHistory();
    fileName.innerHTML = '';
    //codeEditor.clearGutter("ID");
};

btnNew.addEventListener('click', (e) => {
    resetEditor();
    e.stopPropagation();
    e.preventDefault();
});

btnOpen.addEventListener('click', (e) => {
    fileLoader.load(function (data) {
        let content = data.content.byteLength % 2 == 1 ? new Uint8Array(data.content) : new UInt16Array(data.content);
        fileName.innerHTML = data.name;
        codeEditor.setValue((new TextDecoder('utf-8')).decode(data.content));
    });
    e.stopPropagation();
    e.preventDefault();
});

btnSave.addEventListener('click', (e) => {
    fileLoader.save(fileName.innerHTML, codeEditor.getValue());
    console.log('TOOLS:SAVE');
    e.stopPropagation();
    e.preventDefault();
});
