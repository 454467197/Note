import React  from 'react';
import { Input } from 'antd';
 
 

 class App extends React.Component{
     
    


     render(){
        console.log(Input);
        
     return <div style={{margin:'0 auto', width:'400px' ,height:'100px',border:'1px solid #F00'}}>
      
          <Input  style={{width:'200px'}} />
          <br/>
         <Input type='textarea'  style={{width:'400px'}}   />
     
   
     
   </div>
 }
}


export default App;
 



 