import React from 'react'
import '../src/styles/index.scss'
import { addDecorator } from '@storybook/react'
import { ThemeProvider } from '@material-ui/core/styles'

import MuiTheme from '../src/styles/MuiTheme'

addDecorator(story => <ThemeProvider theme={MuiTheme}>{story()}</ThemeProvider>)

export const parameters = {
  actions: { argTypesRegex: '^on[A-Z].*' }
}
