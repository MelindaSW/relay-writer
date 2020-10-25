import React, { useState } from 'react'
import { Typography, Divider, ButtonGroup } from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'
import { Header, Button } from '../../components'
import { SignInForm, SignUpForm } from './logincomponents'
import './loginPage.scss'

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    backgroundColor: theme.palette.primary.dark,
    height: '2px'
  }
}))

const LoginPage = () => {
  const dividerClasses = useStyles()
  const [signIn, setSignIn] = useState(true)
  const [signUp, setSignUp] = useState(false)

  const handleOnClickShowForm = displayForm => {
    if (displayForm === 'signin') {
      setSignIn(true)
      setSignUp(false)
    }
    if (displayForm === 'signup') {
      setSignUp(true)
      setSignIn(false)
    }
  }

  return (
    <div id="loginpage">
      <Header children="DND RELAY-WRITER" />
      <div className="subtitle">
        <Typography variant="subtitle2">
          Welcome to the Dungeons & Dragons themed relay writing webapp!
        </Typography>
      </div>
      <Divider classes={dividerClasses} />
      <div className="bodytext">
        <Typography variant="body2">
          Do you want to collaborate on character backstory creation?
        </Typography>
        <Typography variant="body2">Join us here!</Typography>
      </div>
      <Divider classes={dividerClasses} />
      <div id="buttons">
        <ButtonGroup variant="text" size="large" aria-label="text button group">
          <Button
            children="Sign in"
            color="primary"
            onClick={() => handleOnClickShowForm('signin')}
            outlined
          />
          <Button
            children="Sign up"
            color="secondary"
            onClick={() => handleOnClickShowForm('signup')}
          />
        </ButtonGroup>
      </div>
      <div id="forms">
        {(signIn && <SignInForm />) || (signUp && <SignUpForm />)}
      </div>
    </div>
  )
}

export default LoginPage
