
import React from 'react'
import { Route } from 'react-router-dom'
import { Redirect } from 'react-router'

const SecureRoute = ({ component: Component, auth, ...other }) => {
    return (
        <Route
            { ...other }
            render={ props => {
                if (auth === false) return <Redirect to="/" />
                if (auth) return <Component auth={ auth } { ...props } />
            } }
        />
    )
}

export default SecureRoute