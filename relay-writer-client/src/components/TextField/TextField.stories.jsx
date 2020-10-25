import React from 'react'
import TextField from './index'

export default {
  title: 'components/TextField',
  component: TextField,
  argTypes: {}
}

const Template = args => <TextField {...args} />

export const Primary = Template.bind({})
Primary.args = {}

export const Secondary = Template.bind({})
Secondary.args = { color: 'secondary', size: 'small' }
