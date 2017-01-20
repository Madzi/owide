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
    rows: [
        {
            type: 'clean',
            cols: [
                {
                    view: 'menu',
                    data: [
                        {
                            id: 1,
                            value: 'File',
                            submenu: ['New', 'Open', 'Save']
                        }
                    ],
                    css: 'blue'
                }
            ]
        },
        {
            cols: [
                {
                    id: 'f',
                    view: 'tree',
                    data: [
                        { value: 'f01' },
                        { value: 'f02' },
                        { value: 'f03' },
                        { value: 'f04' },
                        { value: 'f05' },
                        { value: 'f06' },
                        { value: 'f07' },
                        { value: 'f08' },
                        { value: 'f09' },
                        { value: 'f10' },
                        { value: 'f11' },
                        { value: 'f12' },
                        { value: 'f13' },
                        { value: 'f14' },
                        { value: 'f15' },
                        { value: 'f16' },
                        { value: 'f17' },
                        { value: 'f18' },
                        { value: 'f19' },
                        { value: 'f20' },
                        { value: 'f21' }
                    ],
                    width: 200
                },
                {
                    view: 'resizer'
                },
                {
                    id: 'e'
                }
            ]
        },
        {
            view: 'resizer'
        },
        {
            id: 'c',
            view: 'list',
            data: [
                'Line - 01',
                'Line - 02',
                'Line - 03',
                'Line - 04',
                'Line - 05',
                'Line - 06',
                'Line - 07',
                'Line - 08'
            ],
            height: 100
        }
    ]
});
