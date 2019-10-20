<template lang="html">
   <div class="column has-text-centered">
      <h1 class="title is-1 is-uppercase">WELCOME</h1>
      <p>
         This is a relay-writing experiment for DND character background stories.
      </p>
      <p>
         Choose whether you want to start a new character story or continue on one that is already created.
      </p>
      <p>
         <router-link to="/startanewstory">
            <button class="button is-outlined is-medium" name="startanewstory" value="Start a new story">Start a new story</button>
         </router-link>
      </p>
      <p>
         <router-link to="/pickastory">
            <button class="button is-outlined is-medium" name="pickastory">Pick a story</button>
         </router-link>
      </p>
   </div>
</template>

<!--
Pressing the button startanewstory should send the user to the NewStory where they can name the story and write the first snippet, and then submit the new story.
It should also trigger @click to set the data value isNewStory to 'yes' so it can be used in the parameter for the post action.

Pressing the button pickastory should send the user to the page where a list of the already created stories are displayed.
 -->


<script>
   export default {
   }
</script>

<style lang="css" scoped>
</style>
