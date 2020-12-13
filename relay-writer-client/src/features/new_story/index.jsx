import React, { useState,/* useEffect, useRef*/ } from 'react'
import { connect } from 'react-redux'
import { postCreateNewStory } from '../../axios/api'
import { TextField, Button } from '../../components'
import { Divider } from '@material-ui/core'
import { useDividerStyles } from './newStory.styles'
import './newStory.scss'

const NewStory = props => {
  const dividerClasses = useDividerStyles()
  const [allFieldsFilled, setAllFieldsFilled] = useState(false)
  const [formState, setFormState] = useState({
    title: '',
    description: '',
    name: '',
    race: '',
    class: '',
    snippet: ''
  })

  setAllFieldsFilled(true)
  setFormState({})
  // const handleOnChange = event => {
  //   console.log('on change triggered')
  // }

  const onSubmit = () => {
    postCreateNewStory(formState)
  }

  return (
    <div id="new-story">
      <header id="information">
        <h3 className="title">Create a new story</h3>
        <p>Lorem ipsum and so on</p>
      </header>
      <form>
        <TextField
          class="form-fields"
          id="title"
          label="Title"
          name="title"
          value={formState.title}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="short-description"
          label="Short description"
          name="description"
          value={formState.description}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="name-of-character"
          label="Name of character"
          name="name"
          value={formState.name}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="dnd-race"
          label="DND race"
          name="race"
          value={formState.race}
          variant="outlined"
          placeholder=""
          required
        />
        <TextField
          class="form-fields"
          id="dnd-class"
          label="DND Class"
          name="class"
          value={formState.class}
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
          name="snippet"
          value={formState.snippet}
          rows={15}
          rowsMax={10}
          required
        />
        <Divider classes={dividerClasses} />
        <div id="button">
          <Button
            onClick={onSubmit}
            type="submit"
            children="Create"
            disabled={allFieldsFilled}
          />
        </div>
      </form>
    </div>
  )
}
const mapStateToProps = ({ newStoryState }) => {
  return { newStoryState }
}

export default connect(mapStateToProps)(NewStory)
