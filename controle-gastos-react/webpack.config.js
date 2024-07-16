const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: {
        home: path.resolve(__dirname, 'src/pages/js/Home.js'),
        people: path.resolve(__dirname, 'src/pages/js/People.js'),
    },
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: '[name].bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: ['file-loader']
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            filename: path.resolve(__dirname, 'src/pages/html/Home.html'),
            template: path.resolve(__dirname, 'src/pages/html/template.html'),
            chunks: ['home'],
            title: 'Home',
            script: 'home.bundle.js',
            inject: false
        }),
        new HtmlWebpackPlugin({
            filename: path.resolve(__dirname, 'src/pages/html/People.html'),
            template: path.resolve(__dirname, 'src/pages/html/template.html'),
            chunks: ['people'],
            title: 'Pessoas',
            script: 'people.bundle.js',
            inject: false
        }),
    ],
    devServer: {
        static: {
            directory: path.resolve(__dirname, 'src/pages/html'),
        },
        port: 9000,
        open: true,
    },
};
