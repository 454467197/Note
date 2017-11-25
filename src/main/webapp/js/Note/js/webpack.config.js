/*
          ___                _
         / __|___  ___  __ _| |___
        | (_ / _ \/ _ \/ _` |   -_)
         \___\___/\___/\__, |_\___|
                       |___/  

                         javalei.com


             this is javalei.com&&react6.com fisrt webpack config
         
*/
var webpack = require("webpack");

var ismobile=false;

module.exports={
    entry:{
        bundle:'./index'  //编译后文件:编译前源码
    },
    output:{
        filename:'./index/[name].bundle.js', //输出文件名        
    },
  
    module:{
        loaders:[
             //js、css、less解析，这里要注意babel必须配置.babelrc文件，其中"presets": ["es2015"]用于支持es6语法，"plugins": ["transform-react-jsx"]用于解析jsx
              //{test:/\.js$/, loader: 'react-hot!babel', exclude: /node_modules/},
            //  { test: /\.js$/, exclude: /node_modules/, loader: 'babel-loader' },
			 // { test: /\.less$/, loader: 'style-loader!css-loader!less-loader' }, 
            //  { test: /\.jsx$/, exclude: /node_modules/, loader: 'babel-loader' },
            //  { test: /\.jpe?g$|\.gif$|\.eot$|\.png$|\.svg$|\.woff$|\.woff2$|\.ttf$/, loader: "file" },
            //  { test: /\.css$/, loader: 'style-loader!css-loader' }
             { test: /\.js$/, exclude: /node_modules/, loader: 'babel-loader' },
           	{ test: /\.less$/, loader: 'style-loader!css-loader!less-loader' }, 
      { test: /\.css$/, loader: 'style-loader!css-loader' }
		
        ]

    }



}

