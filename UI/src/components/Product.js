import React, { Component } from 'react';
import propTypes from 'prop-types'
import { addToCart} from './actions/cartActions'
import { connect } from 'react-redux'
import '../index.css'

const Product = ({ handleClose, show, children, products, id }) => {
        const showHideClassName = show ? "modal display-block" : "modal display-none";
        return(
                <div className={showHideClassName}>
                    <section className="modal-main">
                    <div className="container" key={id}>
                    <table>
                        <th>ID</th>  <th>NAME</th> <th>DESCRIPTION</th> <th>CURRENCY TYPE</th> <th>PRICE</th> 
                            { products.map(product=> 
                                    <tr>
                                        <td> {product.id}</td>
                                        <td> {product.name}</td>
                                        <td> {product.descriptions}</td>
                                        <td> {product.currencyType} </td>
                                        <td> {product.itemPrice}</td>
                                    </tr> 
                            ) }
                    </table>
                    </div>    
                    <button type="button" onClick={handleClose}>Close</button>
                    </section>
                </div>
                )
            }       

export default Product