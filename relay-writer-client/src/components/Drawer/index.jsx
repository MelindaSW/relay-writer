import React from 'react'
import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'
import FeatureRoutes from '../../routes/FeatureRoutes'
import {
  Typography,
  Toolbar,
  ListItemText,
  ListItem,
  List,
  IconButton,
  Hidden,
  Drawer,
  Divider,
  AppBar
} from '@material-ui/core'
import MenuIcon from '@material-ui/icons/Menu'
import ElevationScroll from './ElevationScroll'
import { useTheme } from '@material-ui/core/styles'
import { useStyles } from './drawer.styles'
import logo from '../../assets/relay-writer-logo-500px.png'
import './drawer.scss'

const ResponsiveDrawer = ({ title, drawerItems }) => {
  const classes = useStyles()
  const theme = useTheme()
  const [mobileOpen, setMobileOpen] = React.useState(false)

  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen)
  }

  const drawer = (
    <div>
      <div id="menuimage">
        <img src={logo} alt="rw-icon" />
      </div>
      {/* <div className={classes.toolbar} /> */}
      <Divider />
      <List>
        {drawerItems.map((item, index) => (
          <Link to={item.link} key={index}>
            <ListItem button onClick={handleDrawerToggle}>
              <ListItemText primary={item.text} />
            </ListItem>
            <Divider />
          </Link>
        ))}
      </List>
    </div>
  )

  return (
    <div className={classes.root}>
      <ElevationScroll>
        <AppBar position="fixed" className={classes.appBar}>
          <Toolbar>
            <IconButton
              color="inherit"
              aria-label="open drawer"
              edge="start"
              onClick={handleDrawerToggle}
              className={classes.menuButton}
            >
              <MenuIcon />
            </IconButton>
            <Typography variant="h6" noWrap>
              {title}
            </Typography>
          </Toolbar>
        </AppBar>
      </ElevationScroll>
      <nav className={classes.drawer} aria-label="mailbox folders">
        <Hidden smUp>
          <Drawer
            variant="temporary"
            anchor={theme.direction === 'rtl' ? 'right' : 'left'}
            open={mobileOpen}
            onClose={handleDrawerToggle}
            classes={{
              paper: classes.drawerPaper
            }}
            ModalProps={{
              keepMounted: true // Better open performance on mobile.
            }}
          >
            {drawer}
          </Drawer>
        </Hidden>
        <Hidden xsDown>
          <Drawer
            classes={{
              paper: classes.drawerPaper
            }}
            variant="permanent"
            open
          >
            {drawer}
          </Drawer>
        </Hidden>
      </nav>
      <main className={classes.content}>
        <div className={classes.toolbar} />
        <FeatureRoutes />
        {/* Main features here, Create new story, continue story etc */}
      </main>
    </div>
  )
}

ResponsiveDrawer.propTypes = {
  drawerItems: PropTypes.array,
  title: PropTypes.string
}

export default ResponsiveDrawer
