import React from 'react'
import './styles/App.scss'
import { BrowserRouter } from 'react-router-dom'
import Routes from './routes/Routes'
import { ThemeProvider } from '@material-ui/core/styles'
import MuiTheme from './styles/MuiTheme'

const App = () => {
  return (
    <ThemeProvider theme={MuiTheme}>
      <div className="App">
        <BrowserRouter>
          <Routes />
        </BrowserRouter>
      </div>
    </ThemeProvider>
  )
}

export default App
