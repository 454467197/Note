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
    render: (data) => data==0?"未完成":"已完成"
  }, {
    title: '标题',
    dataIndex: 'dname',
    key: 'dname',
    render: (data) => <a href="#">{data}</a>
  }, {
    title: '内容',
    dataIndex: 'content',
    key: 'content',
  }];



   
   
 
  let _this;
    class ShowAll extends React.Component{
      
      constructor(prop){
        console.log("fetch",fetch)
        super(prop)
        notification.open({
          message: 'Success',
          description: '已经成功加载数据'
        });
        _this=this;
       
       
      }

        componentWillMount(){
           console.log("componentWillMount",this.props)
            const {getAll} =this.props;


            fetch('/all.do')
                .then((data)=> data.json()).then((data)=>{
                getAll(data);

            })
        }



        enterIconLoading(){
       const {data,adddata}=this.props;
       
       adddata(data.length,0,_this.refs.name.refs.input.value,_this.refs.text.refs.input.value);
           
      }

      p1(data,error){
        return new Promise(function(resolve,reject){
          resolve("test");
          setTimeout(function(){
            console.log("this is p1");
          },3000)

        })
      }

      p2(data,error){
        return new Promise(function(resolve,reject){
          console.log("data",data)
          console.log('error',error);
          resolve("test2");
          setTimeout(function(){
            console.log("this is p2");
          },3000)

        })
      }
      p3(data,error){
        return new Promise(function(resolve,reject){
          console.log("data",data)
          console.log('error',error);
          resolve("---p3");
          setTimeout(function(){
            console.log("this is p3");
          },3000)

        })
      }
      p4(data,error){
        console.log("data",data)
        console.log('error',error);
        return new Promise(function(resolve,reject){
          setTimeout(function(){
            console.log("this is p4");
          },3000)

        })
      }


      render(){
         const {p1,p2,p3,p4}=_this;
         const {data}=this.props;

         // p1().then(p2).then(p3).then(p4);
         
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
        },
        getAll:(data)=>{
           dispatch({type:"getall",data:data});
      }
     }
    }
  
  
  //connect(mapStateToProps,mapDispatchToProps)
    export default connect(mapStateToProps,mapDispatchToProps)(ShowAll);
  