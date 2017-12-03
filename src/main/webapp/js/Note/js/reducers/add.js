import * as Actiontypes from '../action/acitonTypes'; 
 
import  Immutable from 'immutable'


 
const initstate={data:[{
    
    id     : 32,
    state  : "已完成",
    dname  : "吴彦祖的事情",
    content: "西湖区湖底公园1号"
  }]}




export default function(state=initstate,action){

    
    switch(action.type){
        case Actiontypes.ADDNOTE: 
  
           let s= [...state.data,{
                //key:state.data[state.data.length-1].key+1,
                id     : action.data.id,
                state  : action.data.state,
                dname  : action.data.dname,
                content: action.data.content
                }]
         
          let ss      = [...state];
              ss.data = s;
        return ss;
           
        case Actiontypes.GETALL: 
            let ss2      = [...state];
                ss2.data = action.data;
            return ss2;
     default: 
        return state;
    }
} 