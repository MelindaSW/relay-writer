const newStoryState = {
  authorId: null,
  storyId: null,
  title: '',
  characterName: '',
  characterRace: '',
  characterClass: '',
  snippets: []
}

export function newStoryReducer(state = newStoryState, action) {
  switch (action.type) {
    case 'NEW_STORY':
      return { ...state, title: 'New title' }
    default:
      return state
  }
}
