import { makeStyles } from '@material-ui/core/styles'

export const useStyles = makeStyles(theme => ({
  root: {
    backgroundColor: props =>
      props.color === 'primary'
        ? theme.palette.primary.main
        : theme.palette.secondary.dark,
    color: props =>
      props.color === 'primary'
        ? theme.palette.primary.contrastText
        : theme.palette.secondary.contrastText,
    borderRadius: '0px',
    border: props =>
      props.variant === 'outlined'
        ? '1px solid' + theme.palette.primary.dark
        : 'none'
  },
  disabled: {
    color: theme.palette.primary.light,
    backgroundColor: theme.palette.primary.main
  }
}))
