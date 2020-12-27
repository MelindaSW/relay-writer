// import { postCreateNewStory, postNewStorySnippet } from '../../axios/api'

const updateFormState = (eventId, newValue, formState) => {
  switch (eventId) {
    case 'story-title':
      formState.title = newValue
      break
    case 'short-description':
      formState.description = newValue
      break
    case 'name-of-character':
      formState.characterName = newValue
      break
    case 'dnd-race':
      formState.characterRace = newValue
      break
    case 'dnd-class':
      formState.characterClass = newValue
      break
    case 'start-your-story-here':
      formState.snippet = newValue
      break
    default:
      break
  }
  return formState
}

const handleSubmit = async (formState, dispatch) => {
  //   await postCreateNewStory(formState, props.dispatch)
  //   await postNewStorySnippet(snippetState, props.dispatch)
}

export { updateFormState, handleSubmit }
