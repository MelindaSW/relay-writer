import { create } from '@storybook/theming/create'

export default create({
  base: 'light',

  colorPrimary: 'grey',
  colorSecondary: 'deepskyblue',

  // UI
  appBg: 'lightgrey',
  appContentBg: '#dbedf3',
  appBorderColor: 'grey',
  appBorderRadius: 4,

  // Typography
  fontBase: '"Open Sans", sans-serif',
  fontCode: 'monospace',

  // Text colors
  textColor: 'black',
  textInverseColor: 'rgba(255,255,255,0.9)',

  // Toolbar default and active colors
  barTextColor: 'white',
  barSelectedColor: 'black',
  barBg: 'darkgrey',

  // Form colors
  inputBg: 'white',
  inputBorder: 'silver',
  inputTextColor: 'black',
  inputBorderRadius: 4,

  brandTitle: 'Storybook for dnd-relay-writer',
  brandUrl: 'https://melindasw.se'
  //   brandImage: 'https://placehold.it/350x150'
})
