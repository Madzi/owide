import IdeCore from './ide-core';

let codeArea = document.querySelector('#code-area'),
    ideEditor = CodeMirror.fromTextArea(codeArea, {
        lineNumbers: true
    }),
    ideCore = new IdeCore();

/* Add events to menu */
document.querySelector('#menu-item-new').addEventListener('click', e => {
    ideCore.fileNew();
    codeEditor.setValue(ideCore.file.content);
    codeEditor.clearHistory();
});

document.querySelector('#menu-item-open').addEventListener('click', e => {
    ideCore.fileOpen();
    codeEditor.setValue(ideCore.file.content);
    codeEditor.clearHistory();
});

document.querySelector('#menu-item-save').addEventListener('click', e => {
    ideCore.fileSave();
});
