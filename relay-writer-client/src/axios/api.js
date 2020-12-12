const { default: Axios } = require('axios')

const axios = require('axios')

const postCreateNewStory = data => {
  console.log(data)
  // Send a POST request
  axios({
    method: 'post',
    url: '/user/12345',
    data: JSON.stringify(data, data)
  })
    .then(response => console.log(response))
    .catch(err => console.log(err))
}

export { postCreateNewStory }
