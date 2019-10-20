// const path = require('path')
// path not working with require path, TODO: figure out why...
const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports = {
  // entry: './src/index.js',
  mode: 'development',
  module: {
     rules: [
       {
         loader: ['vue-style-loader', 'css-loader'],
         test: /\.css$/
       },
       {
         loader: 'vue-loader',
         test: /\.vue$/
       },
       {
	     loader: ['vue-style-loader', 'css-loader', 'sass-loader'],
         test: /\.scss$/	
       },
       {
         test: /\.(png|svg|jpg|gif)$/,
         use: [
           'file-loader'
         ]
        }
      ],
   },
  output: {
    filename: 'bundle.js',
    path: __dirname + '/public'
    // path: path.resolve(__dirname, '/public')
  },
  plugins: [
    new VueLoaderPlugin()
  ],
  resolve: {
    alias: {
      vue: 'vue/dist/vue.js'
    }
  }
}
