import React, { Component } from 'react';
import propTypes from 'prop-types'
import { addToCart} from './actions/cartActions'
import { connect } from 'react-redux'
import Product from './Product'

class Packages extends Component{

    constructor(props) {
        super(props);
        this.products = [];
        this.package_id = 0;
        this.state = {
            show: false
        };
        this.showDetail = this.showDetail.bind(this);
        this.showModal = this.showModal.bind(this);
        this.hideModal = this.hideModal.bind(this);
    }
    
    showModal = () => {
        this.setState({ show: true });
    }
    
    hideModal = () => {
        this.setState({ show: false });
    }

    handleClick = (id)=>{
        console.log("ID is : " + id)
        this.show=false;
        this.props.addToCart(id); 
    }

    showDetail = (id, products, e)=> {
        console.log("This is a click event: " +  e + " ID:" + id + " Products length:" +products.length)
        this.show=false;
        this.products = products;
        this.package_id = id;
        
    }
    
    render(){
            return (
                <div className="container" key={this.props.packages[0].id}>
                    <table>
                        <th>ID</th>  <th>NAME</th> <th>DESCRIPTION</th> <th>CURRENCY TYPE</th> <th>PRICE</th> <th> DETAIL</th> <th> ADD TO BASKET </th>
                        { this.props.packages.map(pack=>
                            <tr>
                                <td>{pack.id}</td>
                                <td>{pack.name}</td>
                                <td>{pack.description}</td>
                                <td>{pack.currencyType}</td>
                                <td>{pack.price}</td>
                             
                            <Product show={this.state.show} handleClose={this.hideModal} products={pack.products} id={pack.products[0].id}>
                                <p>Products</p>
                            </Product>
                               <td> <button type="button" onClick={this.showModal}>View Detail</button> </td>
                               <td>
                                    <button to="/" onClick={()=>{this.handleClick(pack.id)}}>
                                        Add
                                    </button>
                                </td>

                               </tr>
                        )}
                    </table>
                </div>
            )   
    }
}


Packages.propTypes = {
    addToCart: propTypes.func.isRequired
}

const mapDispatchToProps= (dispatch)=>{
    return{
        addToCart: (id)=> { console.log("addToCart -> called " + id); 
                            dispatch(addToCart(id)) 
                        }
    }
}


export default connect(null, mapDispatchToProps)(Packages)