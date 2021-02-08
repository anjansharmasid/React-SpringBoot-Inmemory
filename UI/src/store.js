import { createStore, applyMiddleware } from 'redux';
import  thunk from 'redux-thunk';
import rootReducer from './components/reducers'


const initialStates = {};
const middleware = [thunk];
const store = createStore(rootReducer, initialStates , applyMiddleware(...middleware));
//export default createStore(rootReducer, initialStates , applyMiddleware(thunk.default));
export default store;
