<template lang="html">
   <div class="">
      <h1 class="title is-1 is-uppercase has-text-centered">LIBRARY</h1>
      <div class="subtitle has-text-centered">
         Choose a story that you'd like to contibrute to.
      </div>
      <div class="has-text-centered" id="storylist" v-if="stories.length > 0" >

         <div id="storylistcontent" v-for="(story, index) in stories" :key="story.storyid">
            <p>
               <dl class="">
                  <strong><dt class="is-uppercase">{{ story.title }}</dt></strong>
                  <dd>{{ story.description }} </dd>
               </dl>
            </p>
            <router-link :to="{ name: 'editstory', params: { title: story.title }}">
               <button class="button" @click="storyWasChosen(story.storyid, story.title, story.description)" type="button" name="button">Pick me!</button>
            </router-link>

         </div>
      </div>
   </div>
</template>
<!-- The router link to the edit story page should be /editastory/nameofstory-->
<script>
   export default {
      computed: {
         stories() {
            return this.$store.state.stories
         },
         title() {
            return this.$store.state.title
         }
      },
      created() {
         this.$store.dispatch('getAllStories')
      },
      methods: {
         storyWasChosen(storyid, title, description) {
            this.$store.commit('setStoryId', storyid)
            this.$store.commit('setTitle', title)
            this.$store.commit('setDescription', description)
         }
      }


   }
</script>

<style lang="css" scoped>
   #storylist{
         border: solid 4px Gainsboro;
         padding: 3rem;
   }
   #storylistcontent {
      border: solid 2px white;
      padding: 1rem;
   }
</style>
