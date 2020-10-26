import React from 'react'
import SignUpForm from './index'

export default {
  title: 'components/SignUpForm',
  component: SignUpForm,
  argTypes: {}
}

const Template = args => (
  <div style={{ width: '30%' }}>
    <SignUpForm {...args} />
  </div>
)

export const SignUp = Template.bind({})
SignUp.args = {}
