import { makeStyles } from '@material-ui/core/styles'

const drawerWidth = 240

export const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex'
  },
  drawer: {
    [theme.breakpoints.up('sm')]: {
      width: drawerWidth,
      flexShrink: 0
    }
  },
  appBar: {
    backgroundColor: theme.palette.primary.dark,
    color: theme.palette.primary.light,
    zIndex: theme.zIndex.drawer + 1,
    height: '100px'
  },
  menuButton: {
    marginRight: theme.spacing(1),
    [theme.breakpoints.up('sm')]: {
      display: 'none'
    }
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  drawerPaper: {
    width: drawerWidth,
    marginTop: '100px',
    height: '70%'
  },
  content: {
    flexGrow: 1
  }
}))
