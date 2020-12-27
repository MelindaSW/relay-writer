import { updateFormState } from './newStoryHelpers'

test('updateFormState should update title value', () => {
  const eventId = 'story-title'
  const newValue = 'updated title'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: newValue,
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})

test('updateFormState should update description value', () => {
  const eventId = 'short-description'
  const newValue = 'updated description'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: 'test title',
    description: newValue,
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})

test('updateFormState should update name value', () => {
  const eventId = 'name-of-character'
  const newValue = 'updated name'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: 'test title',
    description: 'test description',
    characterName: newValue,
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})

test('updateFormState should update race value', () => {
  const eventId = 'dnd-race'
  const newValue = 'updated race'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: newValue,
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})

test('alterFormState should update class value', () => {
  const eventId = 'dnd-class'
  const newValue = 'updated class'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: newValue,
    creatorId: 1,
    snippet: 'test snippet'
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})

test('alterFormState should update snippet value', () => {
  const eventId = 'start-your-story-here'
  const newValue = 'updated snippet'
  const formState = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: 'test snippet'
  }
  const expectedResult = {
    title: 'test title',
    description: 'test description',
    characterName: 'test name',
    characterRace: 'test race',
    characterClass: 'test class',
    creatorId: 1,
    snippet: newValue
  }
  const result = updateFormState(eventId, newValue, formState)
  expect(result).toEqual(expectedResult)
})
