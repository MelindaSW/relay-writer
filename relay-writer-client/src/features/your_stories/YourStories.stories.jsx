import React from 'react'
import ContinueStory from './index'

export default {
  title: 'features/ContinueStory',
  component: ContinueStory,
  argTypes: {}
}

const Template = args => <ContinueStory {...args} />

export const Default = Template.bind({})
Default.args = {}
