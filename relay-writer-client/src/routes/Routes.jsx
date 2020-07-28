import React from 'react'
import { Switch, Route } from 'react-router-dom'
import SecureRoute from './SecureRoute'

const Routes = () => {
  return (
    <>
      <Switch>
        <Route />
        <Route />
        <SecureRoute />
      </Switch>
    </>
  )
}
