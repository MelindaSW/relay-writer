import React from 'react'

import LoginPage from './index'

export default {
  title: 'Views/Login',
  component: LoginPage,
  argTypes: {}
}

const Template = args => <LoginPage {...args} />

export const Loginview = Template.bind({})
Loginview.args = {}
