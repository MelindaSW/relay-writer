import { makeStyles } from '@material-ui/core/styles'

export const useDividerStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    backgroundColor: theme.palette.secondary.main,
    height: '2px',
    marginTop: '15px',
    padding: '0px 15px'
  }
}))
