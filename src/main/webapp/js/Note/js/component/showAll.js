import React  from 'react';
import {Table,notification,Input,Button} from 'antd'; 
import {connect} from 'react-redux';
import * as actions from '../action/add'

 
   const columns = [{
    title: 'id',
    dataIndex: 'id',
    key: 'id',
  },{
    title: '状态',
    dataIndex: 'state',
    key: 'state',
  }, {
    title: '标题',
    dataIndex: 'dname',
    key: 'dname',
    render: (data) => <a href="#">{data}</a>
  }, {
    title: '内容',
    dataIndex: 'text',
    key: 'text',
  }];


 

   
   
 
  let _this;
    class ShowAll extends React.Component{
      
      constructor(prop){
        super(prop)
        notification.open({
          message: 'Success',
          description: '已经成功加载数据'
        });
        _this=this;
        console.log("prop",prop);
      
       
      }

    

      enterIconLoading(){
       const {data,adddata}=this.props;
       console.log(data.length,"-------");
       adddata(data.length,0,_this.refs.text.refs.input.value,_this.refs.name.refs.input.value);
           
      }
    


      render(){
        console.log(_this);
        const {data}=this.props;
         
       return  <div style={{margin:'300px'}}>
         
         <Table   rowKey="id" dataSource={data} columns={columns} />

         <div style={{marginTop:'50px',textAlign:'center'}}>
          <Input ref='name'  style={{width:'30%'}}  placeholder="请输入您的标题"  />
          <br/>
          <Input ref='text'  style={{marginBottom:'50px',marginTop:'50px',textAlign:'center',width:'30%',height:'220px'}}   type='textarea' />
          <br/>
          <Button type="primary"  onClick={this.enterIconLoading.bind(_this)}>
          Click me!
          </Button>
         </div>
        </div>
      }
  
    }
  
  
    function mapStateToProps(state, ownProps) {
        
       return {data:state.data};
    }

    function mapDispatchToProps(dispatch, ownProps){
      
      return {
        adddata:(id,state,dname,text)=>{
            dispatch(actions.add(id,state,dname,text));
        }
     }
    }
  
  
  //connect(mapStateToProps,mapDispatchToProps)
    export default connect(mapStateToProps,mapDispatchToProps)(ShowAll);
  