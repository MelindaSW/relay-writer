import React, { useEffect, useState } from 'react'
import './searchStories.scss'
import { getAllStories } from '../../axios/storiesApiReq'
import StoriesTable from './StoriesTable/StoriesTable'
import Icon from '@material-ui/core/Icon'
import { mockStoriesData } from '../../utils/mockData'

// [Title] | By [creator] | [Date] | [Finished]
// (Expand for more info)
// A story about the [race] [name]
// [Description]

const SearchStories = props => {
  // const [storiesList, setStoriesList] = useState([])
  const headerData = [
    'Title',
    'Created By',
    'Created At',
    'Finished',
    'Edit/Read',
    'More info'
  ]

  // useEffect(() => {
  //   const list = getAllStories()
  //   console.log(list)
  //   setStoriesList(list !== undefined ? list.data : [])
  // }, [])

  // useEffect(() => {
  //   console.log(storiesList)
  // }, [storiesList])

  return (
    <div id="search-stories">
      <h2 className="title">Search</h2>
      <p className="info">Find stories to read or contribute to here.</p>
      <Icon color="action" style={{ fontSize: 40 }}>
        filter_list
      </Icon>
      <div id="filter-selection"></div>
      <StoriesTable headerData={headerData} rowData={mockStoriesData} />
    </div>
  )
}

export default SearchStories
//search/filter criteria:
// By creator(drop down with all boxes), date created(from and to), name(textbox), show only finished or unfinished (radiobuttons), active, not active.
// Button to activate filtering, no filtering automatically.
// Button to clear all filters
