import React, { useState } from 'react'
import { connect } from 'react-redux'
import { debounce } from 'lodash'
import { updateFormState, handleSubmit } from './newStoryHelpers'
import { TextField, Button } from '../../components'
import { Divider } from '@material-ui/core'
import { useDividerStyles } from './newStory.styles'
import './newStory.scss'

const NewStory = props => {
  const dividerClasses = useDividerStyles()
  // const [allFieldsFilled, setAllFieldsFilled] = useState(false)
  const [formState, setFormState] = useState({
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: props.userState.id,
    snippet: ''
  })

  const debouncedHandleOnChange = debounce(
    eventData =>
      setFormState(
        updateFormState(eventData.id, eventData.newValue, formState)
      ),
    1000
  )

  const handleOnChange = event => {
    const eventData = { id: event.target.id, newValue: event.target.value }
    debouncedHandleOnChange(eventData)
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
        <Divider classes={dividerClasses} />
        <div id="button">
          <Button
            onClick={() => handleSubmit(formState, props.dispatch)}
            type="submit"
            children="Create"
            // disabled={allFieldsFilled}
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
