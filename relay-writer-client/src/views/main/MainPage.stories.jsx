import React from 'react'
import MainPage from './index'

export default {
  title: 'views/MainPage',
  component: MainPage,
  argTypes: {}
}

const Template = args => <MainPage {...args} />

export const Primary = Template.bind({})
Primary.args = {}
