import React from 'react'
import PropTypes from 'prop-types'
import { Typography } from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'
import './header.scss'

const useStyles = makeStyles(theme => ({
  root: {
    ...theme.typography.button,
    padding: theme.spacing(1),
    color: theme.palette.primary.light,
    fontWeight: 'bold'
  }
}))

const Header = ({ children }) => {
  const classes = useStyles()
  return (
    <header>
      <Typography className={classes.root}>{children}</Typography>
    </header>
  )
}

Header.propTypes = {
  children: PropTypes.string
}

export default Header
