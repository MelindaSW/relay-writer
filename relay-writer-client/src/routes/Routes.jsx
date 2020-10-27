import React from 'react'
import { Switch, Route } from 'react-router-dom'
import SecureRoute from './SecureRoute'
import { LoginPage, MainPage } from '../views'

const Routes = () => {
  return (
    <>
      <Switch>
        <Route exact path="/" component={LoginPage} />
        <SecureRoute auth={true} path="/relaywriter" component={MainPage} />
      </Switch>
    </>
  )
}

export default Routes
