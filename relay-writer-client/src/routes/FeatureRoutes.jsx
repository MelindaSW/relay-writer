import React from 'react'
import { Switch, Route } from 'react-router-dom'
import { NewStory, YourStories, SearchStories } from '../features'

const FeatureRoutes = () => {
  return (
    <>
      <Switch>
        <Route path={`/home/create`} component={NewStory} />
        <Route path={`/home/yourstories`} component={YourStories} />
        <Route path={`/home/search`} component={SearchStories} />
      </Switch>
    </>
  )
}

export default FeatureRoutes
