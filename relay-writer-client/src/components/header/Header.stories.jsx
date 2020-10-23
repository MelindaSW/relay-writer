import React from 'react'
import Header from './index'

export default {
  title: 'components/Header',
  component: Header,
  argTypes: {}
}

const Template = args => <Header {...args} />

export const Primary = Template.bind({})
Primary.args = { children: 'dnd relay-writer' }
