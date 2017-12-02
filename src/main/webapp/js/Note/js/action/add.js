import  * as ActionTypes from './acitonTypes';

export const add=(id,state,dname,text)=>{
    let Data={id:id,state:state,dname:dname,content:text};
   
    return {
        type:ActionTypes.ADDNOTE,
        data:Data
    }

}