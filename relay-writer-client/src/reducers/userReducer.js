const userState = {
  id: 0,
  name: 'name'
}

export function userReducer(state = userState, action) {
  switch (action.type) {
    case 'CHANGE_NAME':
      return { ...state, name: action.name }
    default:
      return state
  }
}
