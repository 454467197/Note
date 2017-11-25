import * as Actiontypes from '../action/acitonTypes'; 
 
import  Immutable from 'immutable'


 
const initstate={data:[{
    
    id: 32,
    state:"已完成",
    dname: "吴彦祖的事情",
    text: "西湖区湖底公园1号"
  }]}




export default function(state=initstate,action){
 
    console.log("state");
    console.log(state
    );

    
    switch(action.type){
        case Actiontypes.ADDNOTE:
  
           let s= [...state.data,{
                //key:state.data[state.data.length-1].key+1,
                id:action.data.id,
                state:action.data.state==1?"已完成":"未完成",
                dname:action.data.dname,
                text:action.data.text
                }]
         console.log("s==data",)
          let ss=[...state];
           console.log(ss.data=s);
        return ss;
           
        case Actiontypes.GETALL:
        return state;

        default:
        return state;
    }
} 