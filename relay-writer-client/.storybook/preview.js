import React from 'react'
import { addDecorator } from '@storybook/react'
import { ThemeProvider } from '@material-ui/core/styles'

import MuiTheme from '../src/styles_theme/MuiTheme'

addDecorator(story => <ThemeProvider theme={MuiTheme}>{story()}</ThemeProvider>)

export const parameters = {
  actions: { argTypesRegex: '^on[A-Z].*' }
}
