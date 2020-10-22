import React from 'react'
import './styles/App.scss'
import { BrowserRouter } from 'react-router-dom'
import Routes from './routes/Routes'

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes />
      </BrowserRouter>
    </div>
  )
}

export default App
