import React from 'react'
import ResponsiveDrawer from './index'

export default {
  title: 'components/Drawer',
  component: ResponsiveDrawer,
  argTypes: {}
}

const Template = args => <ResponsiveDrawer {...args} />

export const Primary = Template.bind({})
Primary.args = {
  drawerItems: ['Item 1', 'Item 2', 'Item 3'],
  title: 'Title in toolbar'
}
