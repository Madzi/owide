export class FileLoader {
    constructor () {
        this.fileInput = document.createElement('input');
        this.fileInput.type = 'file';
        this.fileInput.style.display = 'none';
        document.querySelector('body').appendChild(this.fileInput);
        this.fileInput.addEventListener('change', (ev) => {
            let file = this.fileInput.files[0],
                reader = new FileReader();
            reader.addEventListener('load', (e) => {
                if (this.callback) {
                    this.callback({
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
    load (callback) {
        this.callback = callback;
        this.fileInput.click();
    }
    save (fileName, data) {
        this.fileOutput.setAttribute('href', `data:text/plain;base64,${btoa(data)}`);
        this.fileOutput.setAttribute('download', fileName);
        this.fileOutput.click();
    }
    extension (fileName) {
        return (parts = fileName.split('/').pop().split('.')).length > 1 ? parts.pop() : "";
    }
}
