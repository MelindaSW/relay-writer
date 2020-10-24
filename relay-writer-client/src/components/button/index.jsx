import React from 'react'
import PropTypes from 'prop-types'
import { Button as MUIButton } from '@material-ui/core'
import { useStyles } from './button.styles'

const Button = ({
  children,
  color = 'primary',
  disabled = false,
  disableElevation = true,
  disableFocusRipple = false,
  disableRipple = false,
  fullWidth = false,
  onClick = () => console.log('Button clicked!'),
  size = 'medium',
  variant = 'contained'
}) => {
  const styleProps = { color, variant }
  const classes = useStyles({ ...styleProps })
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
  return (
    <MUIButton
      classes={{ root: classes.root, disabled: classes.disabled }}
      {...props}
    />
  )
}

Button.propTypes = {
  children: PropTypes.node,
  disabled: PropTypes.bool,
  color: PropTypes.oneOf(['primary', 'secondary']),
  disableElevation: PropTypes.bool,
  disableFocusRipple: PropTypes.bool,
  disableRipple: PropTypes.bool,
  fullWidth: PropTypes.bool,
  onClick: PropTypes.func,
  size: PropTypes.oneOf(['large', 'medium', 'small']),
  variant: PropTypes.oneOf(['contained', 'outlined', 'text'])
}

export default Button
