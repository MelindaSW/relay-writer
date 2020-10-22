import React from 'react'
import { Button } from '../../components'

export default {
  title: 'components/Button',
  component: Button,
  argTypes: {}
}

const Template = args => <Button {...args} />

export const Primary = Template.bind({})
Primary.args = { children: 'Primary' }

export const Outlined = Template.bind({})
Outlined.args = { variant: 'outlined', children: 'Outlined' }

export const FullWidth = Template.bind({})
FullWidth.args = { fullWidth: true, children: 'Full width' }

export const Secondary = Template.bind({})
Secondary.args = { color: 'secondary', children: 'Secondary' }
