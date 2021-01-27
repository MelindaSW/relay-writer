import React from 'react'
import { addDecorator } from '@storybook/react'
import { ThemeProvider } from '@material-ui/core/styles'
import '../src/index.scss'

import MuiTheme from '../src/sass-and-MUI/MuiTheme'

addDecorator(story => <ThemeProvider theme={MuiTheme}>{story()}</ThemeProvider>)

export const parameters = {
  actions: { argTypesRegex: '^on[A-Z].*' }
}
