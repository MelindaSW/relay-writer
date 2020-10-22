import React from 'react'
import { Button } from '../../components'

export default {
  title: 'components/Button',
  component: Button,
  argTypes: {}
}

const Template = args => <Button {...args} />

export const Default = Template.bind({})
Default.args = {}

export const Outlined = Template.bind({})
Outlined.args = { variant: 'outlined' }

export const FullWidth = Template.bind({})
FullWidth.args = { fullWidth: true }
