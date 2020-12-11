// The current user of the application
const userState = {
  createdAt: '2020-12-01 16:43:56',
  email: 'admin@email.com',
  id: 1, // For dev purposes, a logged in user
  userName: 'Administrator',
  roles: [
    {
      role: 'ADMIN',
      description:
        'User with administrative rights and access to all of the api.'
    }
  ]
}

export function userReducer(state = userState, action) {
  switch (action.type) {
    case 'CHANGE_NAME':
      return { ...state, userName: action.name }
    default:
      return state
  }
}
