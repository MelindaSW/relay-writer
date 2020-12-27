const axios = require('axios')

const getAllStories = () => {
  axios('http://localhost:8080/dnd-relay-writer/story/all')
    .then(res => console.log(res))
    .catch(err => console.log(err))
}

const postCreateNewStory = async (data, dispatch) => {
  const body = {
    characterClass: data.characterClass,
    characterName: data.characterName,
    characterRace: data.characterRace,
    createdAt: new Date(),
    creatorId: data.creatorId,
    description: data.description,
    title: data.title
  }
  const url = 'http://localhost:8080/dnd-relay-writer/story/add'
  const options = {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    data: JSON.stringify(body),
    url
  }
  axios(options)
    .then(res => {
      const postSnippetData = {
        userName: res.data.creator.userName,
        snippet: data.snippet,
        storyId: res.data.id
      }
      postNewStorySnippet(postSnippetData, dispatch)
    })
    .catch(err => {
      console.log(err)
    })
}

const postNewStorySnippet = async (data, dispatch) => {
  const body = {
    author: data.userName,
    createdAt: new Date(),
    snippet: data.snippet,
    storyId: data.storyId
  }
  const url = 'http://localhost:8080/dnd-relay-writer/snippet/add-snippet'
  const options = {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    data: JSON.stringify(body),
    url
  }
  axios(options)
    .then(response => console.log(response))
    .catch(err => console.log(err))
}

export { getAllStories, postCreateNewStory, postNewStorySnippet }
