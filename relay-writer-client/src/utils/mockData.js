const mockStoriesData = [
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 2,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 3,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 4,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 5,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  },
  {
    id: 12,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 22,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 32,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 42,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 25,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  },
  {
    id: 11,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 122,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 13,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 14,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 15,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  },
  {
    id: 1333,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 3223,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 33,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 4333,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 533,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  },
  {
    id: 132,
    title: 'Yet another story title',
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 223,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 323,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 423,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 253,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  },
  {
    id: 113,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 1223,
    title: 'Awesome story title 1',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: true
  },
  {
    id: 133,
    title: 'Awesome story title 2',
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
    createdAt: '2021-07-29T20:09:06.551942',
    finished: false
  },
  {
    id: 143,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: false
  },
  {
    id: 153,
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
    createdAt: '2021-07-29T20:09:06.542426',
    finished: true
  }
]

const mockSnippetsData = [
  {
    id: 1,
    snippet: 'Lorem ipsum dolor sit amet and so on...',
    author: 'User1',
    story: {
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
        createdAt: '2021-08-01T13:46:07.78834'
      },
      createdAt: '2021-08-01T13:46:07.812518',
      finished: false
    },
    createdAt: '2021-08-01T13:46:07.822419'
  },
  {
    id: 2,
    snippet: 'Lorem ipsum dolor sit amet and so on...',
    author: 'User2',
    story: {
      id: 2,
      title: 'Awesome story title yay it is',
      description: 'A short description of the story',
      characterName: 'Ea',
      characterRace: 'Tiefling',
      characterClass: 'Druid',
      creator: {
        id: 2,
        userName: 'user2',
        email: 'email2@email.com',
        createdAt: '2021-08-01T13:46:07.791402'
      },
      createdAt: '2021-08-01T13:46:07.817858',
      finished: false
    },
    createdAt: '2021-08-01T13:46:07.825802'
  },
  {
    id: 3,
    snippet: 'Lorem ipsum dolor sit amet and so on...',
    author: 'User2',
    story: {
      id: 1,
      title: 'Less awesome story title',
      description: 'A short description of the story',
      characterName: 'Kola',
      characterRace: 'Goliath',
      characterClass: 'Barbarian',
      creator: {
        id: 1,
        userName: 'Administrator',
        email: 'admin@email.com',
        createdAt: '2021-08-01T13:46:07.78834'
      },
      createdAt: '2021-08-01T13:46:07.812518',
      finished: false
    },
    createdAt: '2021-08-01T13:46:07.829263'
  },
  {
    id: 4,
    snippet: 'Lorem ipsum dolor sit amet and so on...',
    author: 'User1',
    story: {
      id: 2,
      title: 'Awesome story title again!',
      description: 'A short description of the story',
      characterName: 'Ea',
      characterRace: 'Tiefling',
      characterClass: 'Druid',
      creator: {
        id: 2,
        userName: 'user2',
        email: 'email2@email.com',
        createdAt: '2021-08-01T13:46:07.791402'
      },
      createdAt: '2021-08-01T13:46:07.817858',
      finished: false
    },
    createdAt: '2021-08-01T13:46:07.831732'
  }
]

export { mockStoriesData, mockSnippetsData }
