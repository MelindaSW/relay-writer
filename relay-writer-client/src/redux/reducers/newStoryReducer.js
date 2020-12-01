const newStoryState = {
  title: 'Amazing title',
  race: '',
  class: ''
}

export function newStoryReducer(state = newStoryState, action) {
  switch (action.type) {
    case 'NEW_STORY':
      return { ...state, title: 'New title' }
    default:
      return state
  }
}
