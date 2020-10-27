import React from 'react'
import SearchStories from './index'

export default {
  title: 'features/SearchStories',
  component: SearchStories,
  argTypes: {}
}

const Template = args => <SearchStories {...args} />

export const Default = Template.bind({})
Default.args = {}
