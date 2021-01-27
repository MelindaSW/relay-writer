import React from 'react'
import { Switch, Route, Redirect } from 'react-router-dom'
import SecureRoute from './SecureRoute'
import { LoginPage, MainPage } from '../views'

const Routes = () => {
  return (
    <>
      <Switch>
        <Route exact path="/" component={LoginPage} />
        <SecureRoute auth={true} path="/home" component={MainPage} />
        <Route render={() => <Redirect to="/" />} />
      </Switch>
    </>
  )
}

export default Routes
