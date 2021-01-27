import React from 'react'
import { Footer, Drawer } from '../../components'
import './mainPage.scss'

const drawerItems = [
  { text: 'Home', link: '/home' },
  { text: 'Create story', link: '/home/create' },
  { text: 'Continue story', link: '/home/continue' },
  { text: 'Search stories', link: '/home/search' }
]

const MainPage = () => {
  return (
    <div id="main">
      <Drawer title="DND RELAY-WRITER" drawerItems={drawerItems} />
      <Footer
        content={
          'Repository for this project can be found at github.com/MelindaSW/relay-writer.'
        }
      />
    </div>
  )
}

export default MainPage
