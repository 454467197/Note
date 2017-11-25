/**
 * 
 *  index.js need component
 * 
 *   1.路由
 *   2.组件
 *   
 */

import React from 'react';
import ReactDOM,{render} from 'react-dom';
import {Provider} from 'react-redux';
import { Router, Route, hashHistory } from 'react-router';
import {createStore} from 'redux';
import  add from  './reducers/add';

import  showall from './component/showAll';
import  App from './component/app';
import * as actions from './action/add';


let rootElement = document.getElementById('root')

   
let store=createStore(add,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());
console.log("state",store.getState())
let test=actions.add(1,1,"dname2","文本2内容");
store.dispatch(test);
 test=actions.add(2,2,"dname4","文本3内容");
store.dispatch(test);
console.log(store.getState())

 
    render(
          <Provider store={store}>
            <Router  history={hashHistory} >
                        <Route path="/" component={showall} />
                        <Route path="/app" component={App} />
                       </Router>
                       </Provider>
                ,
         rootElement
    );
    
 