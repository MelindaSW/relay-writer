import React from 'react'
import { connect } from 'react-redux'
import { TextField, Button } from '../../components'
import { Divider } from '@material-ui/core'

import './newStory.scss'

const NewStory = props => {
  return (
    <div id="new-story">
      {/* <h1>New story</h1> */}
      {/* <Container id="form-container" fixed> */}
      <form>
        <Divider fullWidth flexItem />

        <TextField class="form-fields" label="Title" />
        <TextField class="form-fields" label="Short descripion" />
        <TextField class="form-fields" label="Character name" />
        <TextField class="form-fields" label="Race" />
        <TextField class="form-fields" label="Class" />
        <TextField
          class="form-fields"
          label="Once upon a time ..."
          type="text"
          multiline
        />
        <Divider fullWidth flexItem />
        <Button type="submit" children="Create" />
      </form>
      {/* </Container> */}
    </div>
  )
}
const mapStateToProps = ({ newStoryState }) => {
  return { newStoryState }
}

export default connect(mapStateToProps)(NewStory)
