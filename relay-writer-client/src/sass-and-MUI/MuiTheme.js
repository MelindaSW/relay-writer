import { createMuiTheme } from '@material-ui/core/styles'

const MuiTheme = createMuiTheme({
  palette: {
    primary: {
      main: '#00818a',
      dark: '#283149',
      light: '#dbedf3',
      contrastText: '#283149'
    },
    secondary: {
      main: '#404b69',
      contrastText: '#dbedf3'
    }
  },

  // Used by `getContrastText()` to maximize the contrast between
  // the background and the text.
  contrastThreshold: 3,
  // Used by the functions below to shift a color's luminance by approximately
  // two indexes within its tonal palette.
  // E.g., shift from Red 500 to Red 300 or Red 700.
  tonalOffset: 0.2,
  typography: {
    fontFamily: [
      '-apple-system',
      'BlinkMacSystemFont',
      '"Segoe UI"',
      'Roboto',
      '"Helvetica Neue"',
      'Arial',
      'sans-serif',
      '"Apple Color Emoji"',
      '"Segoe UI Emoji"',
      '"Segoe UI Symbol"'
    ].join(',')
  },
  overrides: {
    //   MuiOutlinedInput: {
    //     multiline: {
    //       fontWeight: 'light',
    //       fontSize: '10px',
    //       width: '100%'
    //     }
    //   }
  }
})

export default MuiTheme
