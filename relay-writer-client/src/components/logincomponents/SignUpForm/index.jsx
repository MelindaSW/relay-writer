import React from 'react'
import { Divider } from '@material-ui/core'
import { TextField, Button } from '../../index'
import { useDividerStyles } from '../formstyles/form.styles'
import '../formstyles/forms.scss'

const SignUpForm = () => {
  const dividerClasses = useDividerStyles()
  return (
    <form>
      <TextField
        color="secondary"
        id="email"
        label="Email"
        margin="normal"
        placeholder=""
        required={true}
        variant="outlined"
      />
      <TextField
        color="secondary"
        id="username"
        label="Username"
        margin="normal"
        placeholder=""
        required={true}
        variant="outlined"
      />
      <TextField
        color="secondary"
        id="password"
        label="Password"
        margin="normal"
        placeholder=""
        required={true}
        type="password"
        variant="outlined"
      />
      <TextField
        color="secondary"
        id="confirmpassword"
        label="Confirm Password"
        margin="normal"
        placeholder=""
        required={true}
        type="password"
        variant="outlined"
      />
      <Divider classes={dividerClasses} />
      <div id="button">
        <Button color="secondary" children="Sign up" type="submit" />
      </div>
    </form>
  )
}

export default SignUpForm
