import React from 'react'
import { Switch, Route } from 'react-router-dom'
import SecureRoute from './SecureRoute'
import { LoginPage, MainPage } from '../views'

const Routes = () => {
  return (
    <>
      <Switch>
        <Route exact path="/" component={LoginPage} />
        <Route path="/start" component={MainPage} />
        {/* <SecureRoute /> */}
      </Switch>
    </>
  )
}

export default Routes
