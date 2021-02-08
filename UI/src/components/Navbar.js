import React, { Component } from 'react';
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
 
class Navbar extends Component {

        render(){
                return(
                        <nav className="nav-shop">
                                <div className="container">
                                <ul className="left">
                                <li><Link to="/"> Home </Link></li>
                                </ul>
                                <ul className="left">
                                <Link to="/"> <h5>Package Shopping </h5></Link>
                                </ul>   
                                <ul className="right">
                                        <li><Link to="/cart">Total:$ {this.props.total.toFixed(2)} Discount: $ {this.props.discount.toFixed(2)}</Link></li>
                                        <li><Link to="/cart"><i className="material-icons">shopping_cart</i></Link></li>
                                </ul>
                                </div>
                        </nav>
                )
        }
}
const mapStateToProps = (state)=>{
        return{
            total: state.packages.total,
            discount: state.packages.discount
        }
}

export default connect(mapStateToProps)(Navbar)