var webpack = require('webpack');
var path = require('path');

module.exports = {
    context: path.join(__dirname, 'src'),
    entry: './main.js',
    output: {
        path: path.join(__dirname, 'lib'),
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
