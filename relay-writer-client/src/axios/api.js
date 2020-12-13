const axios = require('axios')

const postCreateNewStory = async data => {
  console.log(data)
  // Send a POST request
  try {
    const response = await axios({
      method: 'post',
      url: '/user/12345',
      data: JSON.stringify(data, data)
    })
    console.log(response)
  } catch (error) {
    console.log(error)
  }
}

export { postCreateNewStory }
