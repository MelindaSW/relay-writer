import React from 'react'
import { Switch, Route, useRouteMatch } from 'react-router-dom'
import { NewStory, ContinueStory, SearchStories } from '../features'

const FeatureRoutes = () => {
  let { url } = useRouteMatch()

  return (
    <>
      <Switch>
        <Route path={`${url}/new`} component={NewStory} />
        <Route path={`${url}/continue`} component={ContinueStory} />
        <Route path={`${url}/search`} component={SearchStories} />
      </Switch>
    </>
  )
}

export default FeatureRoutes
