import React from 'react'
import PropTypes from 'prop-types'
import { Typography } from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'
import './header.scss'

const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(1),
    color: theme.palette.primary.light,
    fontWeight: 'normal'
  }
}))

const Header = ({ children }) => {
  const classes = useStyles()
  return (
    <header>
      <Typography className={classes.root} variant="h6">
        {children}
      </Typography>
    </header>
  )
}

Header.propTypes = {
  children: PropTypes.string
}

export default Header
