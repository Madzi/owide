import {FileHelper, IdeFile} from './files';

let encLine = function (line) {},
    decLine = function (line) {},
    postLoader = function (content) {
        let pwd,
            idx = 0,
            result = [],
            lines = content.split('\n');
        if (lines[idx++] == `${HEADER}`) {
            result.push(`@editor(${lines[idx++]})`);
            pwd = 
        } else {
            result = lines;
        }
        return result.join('\n');
    };

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
    FileHelper.open(function (ideFile) {
        fileName.innerHTML = ideFile.name;
        // check file type and decode
        codeEditor.setValue(ideFile.content);
    });
    e.stopPropagation();
    e.preventDefault();
});

btnSave.addEventListener('click', (e) => {
    theFile.content = codeEditor.getValue();
    // check file type and encode
    FileHelper.save(theFile);
    e.stopPropagation();
    e.preventDefault();
});

let words = function (str) {
    let o = {}, war = str.split(' ') || [];
    (str.split(' ')||[]).forEach(w => o[w] = !!1);
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

/*  */
