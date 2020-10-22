import React from 'react'
import { Header, Sidemenu, Footer } from '../../components'
import './mainPage.scss'

const MainPage = () => {
  return (
    <div>
      <Header>
        <h1>MainPage</h1>
      </Header>
      <Sidemenu>Sidemenu</Sidemenu>
      <main>Content</main>
      <Footer>Footer</Footer>
    </div>
  )
}

export default MainPage
