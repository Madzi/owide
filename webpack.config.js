module.exports = {
    entry: __dirname + '\\src\\main.js',
    output: {
        path: __dirname + '\\lib\\',
        filename: 'owide.js'
    },
    module: {
        loaders: [
            { test: /\.css$/, loader: 'style!css' },
            { 
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /(node_modules)/,
                query: {
                    presets: ['es2015']
                }
            }
        ]
    }
};
