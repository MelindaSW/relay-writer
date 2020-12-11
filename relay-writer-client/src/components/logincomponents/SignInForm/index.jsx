import React from 'react'
// import PropTypes from 'prop-types'
import { Divider } from '@material-ui/core'
import { TextField, Button } from '../../index'
import { useDividerStyles } from '../formstyles/form.styles'
import '../formstyles/forms.scss'

const SignInForm = () => {
  const dividerClasses = useDividerStyles()

  return (
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
  )
}

SignInForm.propTypes = {}

export default SignInForm
