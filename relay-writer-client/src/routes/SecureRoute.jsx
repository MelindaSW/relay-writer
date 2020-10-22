import React from 'react'
import { Route } from 'react-router-dom'
import { Redirect } from 'react-router'

const SecureRoute = ({ component: Component, auth, ...other }) => {
  return (
    <Route
      {...other}
      render={props => {
        return auth ? <Component auth={auth} {...props} /> : <Redirect to="/" />
      }}
    />
  )
}

export default SecureRoute
