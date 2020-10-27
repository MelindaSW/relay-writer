import React from 'react'
import NewStory from './index'

export default {
  title: 'features/NewStory',
  component: NewStory,
  argTypes: {}
}

const Template = args => <NewStory {...args} />

export const Default = Template.bind({})
Default.args = {}
