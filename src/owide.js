import IdeCore from './ide-core';


let ideCore = new IdeCore(),
    codeArea = document.querySelector('#code-area');
    // codeEditor = CodeMirror.fromTextArea(codeArea, {
    //     lineNumbers: true,
    //     mode: "text/x-oberon07"
    // });
let editor = monaco.editor.create(codeArea, {});

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

