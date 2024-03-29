import React, { useState } from 'react'
import { connect } from 'react-redux'
import { updateFormState, handleSubmit } from './newStoryHelpers'
import { TextField, Button } from '../../components'
import { Divider } from '@material-ui/core'
import { useDividerStyles } from './newStory.styles'
import './newStory.scss'

const NewStory = props => {
  const dividerClasses = useDividerStyles()

  const maxDescrLength = 40
  const maxSnippetLength = 150

  const [submitEnabled, setSubmitEnabled] = useState(false)
  const [snippetLength, setSnippetLength] = useState(0)
  const [descrLength, setDescrLength] = useState(0)

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

    if (event.target.id === 'short-description')
      setDescrLength(event.target.value.length)

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
        <div id="information">
          <h3 className="title">Start a new story</h3>
          <p className="info">
            Fill in all fields below to create your story. If you are in need of
            inspiration we recommend visiting{' '}
            <a
              href="https://www.dndbeyond.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              DND beyond
            </a>{' '}
            or{' '}
            <a
              href="https://www.fantasynamegenerators.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              Fantasy name generators
            </a>
            .
          </p>
        </div>
        <Divider classes={dividerClasses} />
        <TextField
          class="form-fields"
          fullWidth={true}
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
          fullWidth={true}
          id="short-description"
          inputProps={{
            maxLength: maxDescrLength
          }}
          label="Short Description"
          name="description"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <div id="counter">
          {descrLength}/{maxDescrLength}
        </div>
        <TextField
          class="form-fields"
          fullWidth={true}
          id="name-of-character"
          label="Name of Character"
          name="character-name"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          fullWidth={true}
          id="dnd-race"
          label="DND Race"
          name="character-race"
          onChange={e => handleOnChange(e)}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          fullWidth={true}
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
          fullWidth={true}
          id="start-your-story-here"
          inputProps={{
            maxLength: maxSnippetLength
          }}
          label="Start Your Story Here"
          type="text"
          variant="outlined"
          placeholder=""
          multiline
          name="story-snippet"
          onChange={e => handleOnChange(e)}
          rows={15}
          maxRows={10}
          required
        />
        <div id="counter">
          {snippetLength}/{maxSnippetLength}
        </div>
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
