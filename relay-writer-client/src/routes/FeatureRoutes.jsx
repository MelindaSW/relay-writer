import React from 'react'
import { Switch, Route, Redirect } from 'react-router-dom'
import { NewStory, ContinueStory, SearchStories } from '../features'

const FeatureRoutes = () => {
  return (
    <>
      <Switch>
        <Route path={`/home/create`} component={NewStory} />
        <Route path={`/home/continue`} component={ContinueStory} />
        <Route path={`/home/search`} component={SearchStories} />
      </Switch>
    </>
  )
}

export default FeatureRoutes
