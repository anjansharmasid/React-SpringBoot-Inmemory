
import { ADD_TO_CART,REMOVE_ITEM,SUB_QUANTITY,ADD_QUANTITY,FETCH_DATA,REMOVE_DISCOUNT,ADD_DISCOUNT} from './action-types/cart-actions'

//add cart action
export const addToCart= (id)=>{
    console.log(" Inside addToCart ->")
    return{
        type: ADD_TO_CART,
        id
    }
}
//remove item action
export const removeItem=(id)=>{
    return{
        type: REMOVE_ITEM,
        id
    }
}
//subtract qt action
export const subtractQuantity=(id)=>{
    return{
        type: SUB_QUANTITY,
        id
    }
}
//add qt action
export const addQuantity=(id)=>{
    return{
        type: ADD_QUANTITY,
        id
    }
}


//https://httpbin.org/get
export const fetchData=()=> dispatch =>{
    console.log("fetchData start -->")
    fetch('https://localhost:8443/api/v1/packages', {
    method: 'GET',
    credentials: 'same-origin',
    redirect: 'follow',
    agent: null,
    headers: {
        "Content-Type": "text/plain",
        'Authorization': 'Basic ' + btoa('admin:password'),
    },
    timeout: 5000})
    .then(res => res.json())
    .then(posts => 
            dispatch({
            type: FETCH_DATA,
            payload: posts
        }))
    }

    // remove already added discount
    export const addDiscount=(id)=>{
        return{
            type: ADD_DISCOUNT,
            id
        }
    }

    // remove already added discount
    export const removeDiscount=(id)=>{
        return{
            type: REMOVE_DISCOUNT,
            id
        }
}