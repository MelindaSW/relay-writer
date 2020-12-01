const userState = {
  id: null,
  userName: '',
  email: ''
}

export function userReducer(state = userState, action) {
  switch (action.type) {
    case 'CHANGE_NAME':
      return { ...state, userName: action.name }
    default:
      return state
  }
}
