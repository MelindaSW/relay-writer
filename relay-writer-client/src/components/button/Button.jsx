import React from 'react'
import PropTypes from 'prop-types'
import { Button as MUIButton } from '@material-ui/core'
import './button.scss'

const Button = ({
  children = 'Button text',
  disabled = false,
  disableElevation = true,
  disableFocusRipple = false,
  disableRipple = false,
  fullWidth = false,
  onClick = () => console.log('Button clicked!'),
  size = 'medium',
  variant = 'contained'
}) => {
  const props = {
    children,
    disabled,
    disableElevation,
    disableFocusRipple,
    disableRipple,
    fullWidth,
    size,
    variant,
    onClick
  }
  return <MUIButton {...props} />
}

Button.propTypes = {
  children: PropTypes.string,
  disabled: PropTypes.bool,
  disableElevation: PropTypes.bool,
  disableFocusRipple: PropTypes.bool,
  disableRipple: PropTypes.bool,
  fullWidth: PropTypes.bool,
  onClick: PropTypes.func,
  size: PropTypes.string,
  variant: PropTypes.string
}

export default Button
