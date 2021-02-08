import React, { Component } from 'react';
import propTypes from 'prop-types'
import { connect } from 'react-redux'
import { fetchData } from './actions/cartActions'
import Packages from './Packages'

class Home extends Component{

    componentWillMount(){   
        this.props.fetchData() 
    }

    render(){

        if(this.props.packages.length < 1){
            return(
                <div className="card">
                    Sorry no packages for sale !
                </div>
            )
        }

        //let itemList = this.props.packages.map(item=>{
            return(
                //<Packages item={item} />
                <Packages packages={this.props.packages} />
            )
        //})

        //return(
        //    <div className="container">
        //        <h5 className="center">Available Packages</h5>
        //        <div className="box">
        //            {itemList}
        //        </div>
        //    </div>
        //)
    }
}


Home.propTypes = {
    fetchData: propTypes.func.isRequired,
    packages:  propTypes.array.isRequired,
}

const mapStateToProps = (state) => ({
    packages: state.packages.items
    }
);

const mapDispatchToProps= (dispatch)=>{
    
    return{
        fetchData: ()=>{ dispatch(fetchData()) }
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Home)




