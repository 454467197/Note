import qr from 'qr-image';
import React, { Component } from 'react'
import PropTypes from 'prop-types'
 
 export class Qrcode extends Component {
    constructor(props) {
        super(props);
        this.state = {
          path: null // 保存二维码SVG的path
        };
      }
      render() {
        return (
          <div>
            <input type="text" placeholder="请输入" 
              onChange={(e)=>{
                const originPath = qr.svgObject(e.target.value).path; //  获得二维码的绘制路径
                this.setState({path: originPath});
              }}/>
            <br/>
            <label>二维码</label><br/>
            <svg width="100%" height="300" ref={(ref)=>this._qrcodeSVG = ref} transform="scale(2)">
              <path d={this.state.path?this.state.path:null}/>
            </svg>
          </div>
        );
      }
 }
 
 export default Qrcode
 

 