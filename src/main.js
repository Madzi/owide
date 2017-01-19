class Node {
    static one (sel) { return document.querySelector(sel); }
    static all (sel) { return document.querySelectorAll(sel); }
}

let codeArea = Node.one('#code-area'),
    codeEditor = CodeMirror.fromTextArea(codeArea, {
        lineNumbers: true
    });
