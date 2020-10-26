import React from 'react'
import SignInForm from './index'

export default {
  title: 'components/SignInForm',
  component: SignInForm,
  argTypes: {}
}

const Template = args => (
  <div style={{ width: '30%' }}>
    <SignInForm {...args} />
  </div>
)

export const SignIn = Template.bind({})
SignIn.args = {}
