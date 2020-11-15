import React from 'react'
// import PropTypes from 'prop-types'
import { Container, Divider } from '@material-ui/core'

import { TextField, Button } from '../../index'
import { useStyles } from '../formstyles/form.styles'
import '../formstyles/forms.scss'

const SignInForm = () => {
  const dividerClasses = useStyles()

  return (
    <Container>
      <form>
        <TextField
          color="secondary"
          id="username"
          margin="normal"
          variant="outlined"
          label="Email or username"
          placeholder=""
          required={true}
        />
        <TextField
          color="secondary"
          id="password"
          margin="normal"
          variant="outlined"
          label="Password"
          type="password"
          placeholder=""
          required={true}
        />
        <Divider classes={dividerClasses} />
        <div id="button">
          <Button children="Sign in" type="submit" />
        </div>
      </form>
    </Container>
  )
}

SignInForm.propTypes = {}

export default SignInForm
