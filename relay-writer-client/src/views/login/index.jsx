import React from 'react'
import { Typography, Divider, ButtonGroup } from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'
import { Header, Button } from '../../components'
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

  return (
    <div id="loginpage">
      <Header children="dnd relay-writer" />
      <div className="subtitle">
        <Typography variant="subtitle1">
          <span> Welcome to the Dungeons & Dragons relay writer! </span>
        </Typography>
      </div>
      <Divider classes={dividerClasses} />
      <div className="bodytext">
        <Typography variant="body1">
          <span>
            Do you want to collaborate on character backstory creation? Join us
            here!
          </span>
        </Typography>
      </div>
      <Divider classes={dividerClasses} />
      <div id="buttons">
        <ButtonGroup variant="text" size="large" aria-label="text button group">
          <Button children="Sign in" color="primary" />
          <Button children="Sign up" color="secondary" />
        </ButtonGroup>
      </div>
      <div id="forms"></div>
    </div>
  )
}

export default LoginPage
