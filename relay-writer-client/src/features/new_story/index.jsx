import React, { useState } from 'react'
import { connect } from 'react-redux'
import { updateFormState, handleSubmit } from './newStoryHelpers'
import { TextField, Button } from '../../components'
import { Divider } from '@material-ui/core'
import { useDividerStyles } from './newStory.styles'
import './newStory.scss'

const NewStory = props => {
  const dividerClasses = useDividerStyles()
  const [submitEnabled, setSubmitEnabled] = useState(false)
  const [snippetLength, setSnippetLength] = useState(0)
  const [formState, setFormState] = useState({
    title: '',
    description: '',
    characterName: '',
    characterRace: '',
    characterClass: '',
    creatorId: props.userState.id,
    snippet: ''
  })

  const handleOnChange = event => {
    setFormState(
      updateFormState(event.target.id, event.target.value, formState)
    )

    if (event.target.id === 'start-your-story-here')
      setSnippetLength(event.target.value.length)

    setSubmitEnabled(
      formState.title.length > 0 &&
        formState.description.length > 0 &&
        formState.characterName.length > 0 &&
        formState.characterRace.length > 0 &&
        formState.characterClass.length > 0 &&
        formState.snippet.length > 0
    )
  }

  return (
    <div id="new-story">
      <form style={{ marginTop: '62px' }}>
        <header id="information">
          <h3 className="title">Start a new story</h3>
        </header>
        <Divider classes={dividerClasses} />
        <TextField
          class="form-fields"
          id="story-title"
          label="Story Title"
          name="story-title"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="short-description"
          label="Short description"
          name="description"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="name-of-character"
          label="Name of character"
          name="character-name"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="dnd-race"
          label="DND race"
          name="character-race"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="dnd-class"
          label="DND Class"
          name="character-class"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="start-your-story-here"
          inputProps={{ maxLength: 150 }}
          label="Start your story here"
          type="text"
          variant="outlined"
          placeholder=""
          multiline
          name="story-snippet"
          onChange={e => handleOnChange(e)}
          rows={15}
          rowsMax={10}
          required
        />
        <div id="counter">{snippetLength}/150</div>
        <Divider classes={dividerClasses} />
        <div id="button">
          <Button
            onClick={() => handleSubmit(formState, props.dispatch)}
            type="submit"
            children="Create"
            disabled={!submitEnabled}
          />
        </div>
      </form>
    </div>
  )
}
const mapStateToProps = ({ newStoryState, userState }) => {
  return { newStoryState, userState }
}

export default connect(mapStateToProps)(NewStory)
