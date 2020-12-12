import React from 'react'
import Footer from './index'

export default {
  title: 'components/Footer',
  component: Footer,
  argTypes: {}
}

const Template = args => <Footer {...args} />

export const Default = Template.bind({})
Default.args = { content: 'Adjustable footer content' }
