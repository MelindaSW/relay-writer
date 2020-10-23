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
    borderRadius: '2px',
    border: props =>
      props.variant === 'outlined'
        ? '1px solid' + theme.palette.primary.dark
        : 'none'
  }
}))
