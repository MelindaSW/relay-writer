import React from 'react'
import { Button, TextField, Card } from '@material-ui/core'
import './loginPage.scss'

const LoginPage = () => {
  return (
    <div id="loginpage">
      <header>
        <h1>dnd-relay-writer</h1>
      </header>
      <form>
        <Card id="signup" variant="outlined">
          <TextField required label="Username" variant="filled" />
          <TextField required label="Email" variant="filled" />
          <TextField
            required
            label="Password"
            variant="filled"
            type="password"
          />
          <Button variant="contained">SIGN UP</Button>
        </Card>
        <Card id="signin" variant="outlined">
          <TextField required label="Username" variant="filled" />
          <TextField
            required
            label="Password"
            variant="filled"
            type="password"
          />
          <Button variant="contained">SIGN IN</Button>
        </Card>
      </form>
    </div>
  )
}

export default LoginPage
