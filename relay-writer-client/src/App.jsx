import React from 'react'
import './App.scss'
import { BrowserRouter } from 'react-router-dom'
import Routes from './routes/Routes'
import { ThemeProvider } from '@material-ui/core/styles'
import MuiTheme from './sass-and-MUI/MuiTheme'

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
