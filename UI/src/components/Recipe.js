import React, { Component } from 'react'
import { connect } from 'react-redux'
class Recipe extends Component{
    
    componentWillUnmount() {
         if(this.refs.shipping.checked)
              this.props.removeDiscount()
    }

    handleChecked = (e)=>{
        if(e.target.checked){
            this.props.addDiscount();
        }
        else{
            this.props.removeDiscount();
        }
    }

    render(){
  
        return(
            <div className="container">
                <div className="collection">
                    <li className="collection-item">
                            <label>
                                <input type="checkbox" ref="shipping" onChange= {this.handleChecked} />
                                <span>Multi buyers discount (10%)  {this.props.discount.toFixed(2)} </span>
                            </label>
                        </li>
                        <li className="collection-item"><b>Total: {this.props.total.toFixed(2)} </b></li>
                    </div>
                    <div className="checkout">
                        <li> Convert  USD {this.props.total.toFixed(2)}  To  [TO DO]  {this.props.total.toFixed(2)} </li>
                    </div>
                    <br></br>
                    <div className="checkout">
                        <button className="waves-effect waves-light btn">Checkout</button>
                    </div>
                 </div>
        )
    }
}

const mapStateToProps = (state)=>{
    return{
       addedItems: state.packages.addedItems,
       total: state.packages.total,
       discount: state.packages.discount
    }
}

const mapDispatchToProps = (dispatch)=>{
    return{
        addDiscount: ()=>{dispatch({type: 'ADD_DISCOUNT'})},
        removeDiscount: ()=>{dispatch({type: 'REMOVE_DISCOUNT'})}
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Recipe)
