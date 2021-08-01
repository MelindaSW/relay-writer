import React, { useEffect, useState } from 'react'
import './searchStories.scss'
import { getAllStories } from '../../axios/storiesApiReq'
import { RadioGroup, Table } from '@material-ui/core'

// [Title] | By [creator] | [Date] | [Finished]
// (Expand for more info)
// A story about the [race] [name]
// [Description]

const stories = [
  {
    id: 1,
    title: 'Awesome story title',
    description: 'A short description of the story',
    characterName: 'Kola',
    characterRace: 'Goliath',
    characterClass: 'Barbarian',
    creator: {
      id: 1,
      userName: 'Administrator',
      email: 'admin@email.com',
      createdAt: '2021-07-29T20:09:06.530502'
    },
    createdAt: '2021-07-29T20:09:06.542426'
  },
  {
    id: 2,
    title: 'Awesome story title',
    description: 'A short description of the story',
    characterName: 'Ea',
    characterRace: 'Tiefling',
    characterClass: 'Druid',
    creator: {
      id: 2,
      userName: 'user2',
      email: 'email2@email.com',
      createdAt: '2021-07-29T20:09:06.532844'
    },
    createdAt: '2021-07-29T20:09:06.551942'
  },
  {
    id: 2,
    title: 'Awesome story title',
    description: 'A short description of the story',
    characterName: 'Ea',
    characterRace: 'Tiefling',
    characterClass: 'Druid',
    creator: {
      id: 2,
      userName: 'user2',
      email: 'email3@email.com',
      createdAt: '2021-07-29T20:09:06.532844'
    },
    createdAt: '2021-07-29T20:09:06.551942'
  }
]

const SearchStories = props => {
  const [storiesList, setStoriesList] = useState([])

  useEffect(() => {
    setStoriesList(getAllStories())
  }, [])

  return (
    <div id="search-stories">
      <h1>Search</h1>
      <RadioGroup></RadioGroup>
      <Table>{stories[0].title}</Table>
    </div>
  )
}

export default SearchStories
//search/filter criteria:
// By creator(drop down with all boxes), date created(from and to), name(textbox), show only finished or unfinished (radiobuttons), active, not active.
// Button to activate filtering, no filtering automatically.
// Button to clear all filters
