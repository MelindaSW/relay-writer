import { combineReducers } from 'redux'
import { userReducer } from './userReducer'
import { newStoryReducer } from './newStoryReducer'

const rootReducer = combineReducers({
  userState: userReducer,
  newStoryState: newStoryReducer
})

export default rootReducer
