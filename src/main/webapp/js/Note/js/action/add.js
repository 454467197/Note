import  * as ActionTypes from './acitonTypes';

export const add=(id,state,dname,text)=>{
    let Data={id:id,state:state,dname:dname,text:text};
    console.log("Data.id",Data.id)
    return {
        type:ActionTypes.ADDNOTE,
        data:Data
    }

}