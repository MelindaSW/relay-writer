import React from 'react'
import { Footer, Drawer } from '../../components'
import './mainPage.scss'

const drawerItems = [
  { text: 'Create story', link: '/relaywriter/new' },
  { text: 'Continue story', link: '/relaywriter/continue' },
  { text: 'Search stories', link: '/relaywriter/search' }
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
