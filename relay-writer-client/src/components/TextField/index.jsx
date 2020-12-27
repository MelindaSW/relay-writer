import React from 'react'
import PropTypes from 'prop-types'
import { TextField as MUITextField } from '@material-ui/core'
import { useStyles } from './textfield.styles'

const TextField = ({
  autoFocus,
  color = 'primary',
  disabled = false,
  label = 'Label text',
  error = false,
  fullWidth = false,
  helperText = '',
  id = '',
  inputProps,
  margin = 'dense',
  multiline = false,
  name = '',
  onChange = () => {
    console.log('Triggered by Textfield onChange')
  },
  placeholder = 'Placeholder text',
  required = false,
  rows = 1,
  rowsMax = 1,
  size,
  type = 'text',
  value,
  variant = 'filled'
}) => {
  const props = {
    autoFocus,
    color,
    disabled,
    label,
    error,
    fullWidth,
    helperText,
    id,
    inputProps,
    margin,
    multiline,
    name,
    onChange,
    placeholder,
    required,
    rows,
    rowsMax,
    size,
    type,
    value,
    variant
  }
  const classes = useStyles()
  return <MUITextField classes={classes} {...props} />
}

TextField.propTypes = {
  autoFocus: PropTypes.bool,
  color: PropTypes.oneOf(['primary', 'secondary']),
  disabled: PropTypes.bool,
  label: PropTypes.string,
  error: PropTypes.bool,
  fullWidth: PropTypes.bool,
  helperText: PropTypes.node,
  id: PropTypes.string,
  margin: PropTypes.oneOf(['dense', 'none', 'normal']),
  multiline: PropTypes.bool,
  name: PropTypes.string,
  onChange: PropTypes.func,
  placeholder: PropTypes.string,
  required: PropTypes.bool,
  rows: PropTypes.number,
  rowsMax: PropTypes.number,
  size: PropTypes.oneOf(['medium', 'small']),
  type: PropTypes.oneOf([
    'button',
    'checkbox',
    'color',
    'date',
    'datetime-local',
    'email',
    'file',
    'hidden',
    'image',
    'month',
    'number',
    'password',
    'radio',
    'range',
    'reset',
    'search',
    'submit',
    'tel',
    'text',
    'time',
    'url',
    'week'
  ]),
  value: PropTypes.string,
  variant: PropTypes.oneOf(['filled', 'outlined', 'standard'])
}

export default TextField
