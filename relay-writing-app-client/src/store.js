import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		author: '',
		description: '',
		message: '',
		newStory: {},
		snippet: '',
		stories: [],
		storyId: '',
		storySnippets: [],
		title: ''
	},
	actions: {

		addStory(context, storyobject) {

			// console.log(JSON.stringify(storyobject))

			fetch('/api/', {
				body: JSON.stringify(storyobject),
				headers: {
					'Content-Type': 'application/json'
				},
				method: 'POST'
			})
			.then(response => response.text())
			.then(result => {
				context.commit('setMessage', result)
				console.log(result)
			})

		},
		addSnippet(context, snippetObject) {

			fetch('/api/?storyid=' + context.state.storyId, {
				body: JSON.stringify(snippetObject),
				headers: {
					'Content-Type': 'application/json'
				},
				method: 'POST'
			})
			.then(response => response.text())
			.then(result => {
				context.commit('setAuthor', 'Anonymous')
				context.commit('setSnippet', '')
				context.dispatch('getStorySnippets', context.state.storyId)
				console.log(result)
			})

		},
		getAllStories(context) {

			fetch('/api/')
			.then(response => response.json())
			.then(result => {
				context.commit('setStories', result)
			})

		},
		getStorySnippets(context, storyid) {

			fetch('/api/?storyid=' + storyid)
			.then(response => response.json())
			.then(result => {
				console.log(result)
				context.commit('setStorySnippets', result)
			})
		}

	},

	mutations: {
		setAuthor(state, author) {
			state.author = author
		},
		setDescription(state, description) {
			state.description = description
		},
		setMessage(state, message) {
			state.message = message
		},
		setNewStory(state, newStory) {
			state.newStory = newStory
		},
		setSnippet(state, snippet) {
			state.snippet = snippet
		},
		setStorySnippets(state, storySnippets) {
			state.storySnippets = storySnippets
		},
		setStories(state, stories) {
			state.stories = stories
		},
		setStoryId(state, storyId) {
			state.storyId = storyId
		},
		setStoryName(state, storyName) {
			state.storyName = storyName
		},
		setTitle(state, title) {
			state.title = title
		}

	}

})

export default store
