<template lang="html">
   <div class="">
      <h1 class="title is-uppercase has-text-centered">Start a new background story</h1>
      <div class="subtitle has-text-centered">
         Need inspiration? Check the game rules at <a href="https://www.dndbeyond.com/">DND Beyond</a> and choose a race and class. A great name generator, and more useful generators, can be found <a href="https://www.fantasynamegenerators.com/dungeons-and-dragons.php">here</a>.
         <p>
            The amount of characters are limited, so make the words count!
         </p>
      </div>

      <div class="field">
         <legend class="label">
            What is the story going to be called?
         </legend>
         <div class="control">
            <input class="input" type="text" v-model="title" placeholder="The amazing title.">
         </div>
      </div>

      <div class="field">
         <legend class="legend">
            Write a short description of the story, or perhaps just the name of the character.
         </legend>
         <div class="control">
            <input class="input" type="text" v-model="description" placeholder="The greatest story of all time!">
         </div>
      </div>

      <snippet-textarea snippet-editor-label="The story begins here!"></snippet-textarea>

      <div class="field">
         <legend class="legend">
            Sign your name, or be...
         </legend>
         <div class="control">
            <input class="input" type="text" v-model="author" placeholder="The one who must not be named">
         </div>
      </div>

      <input class="button" @click="this.addNewStory" type="button" name="" value="Launch your story!">

      <div>
         {{ message }}
      </div>

   </div>
</template>

<script>
   import SnippetTextarea from './shared-components/SnippetTextarea.vue'
   export default {
      components: {
         'snippet-textarea': SnippetTextarea
      },
      computed: {
         author: {
            get() {
               return this.$store.state.author
            },
            set(author) {
               this.$store.commit('setAuthor', author)
            }
         },
         description: {
            get() {
               return this.$store.state.description
            },
            set(description) {
               this.$store.commit('setDescription', description)
            }
         },
         title: {
            get() {
               return this.$store.state.title
            },
            set(title) {
               this.$store.commit('setTitle', title)
            }
         },
         message() {
            return this.$store.state.message
         }
      },
      methods: {
         addNewStory() {

            if (this.title === '' || this.description === '' ||            this.$store.state.snippet === '' || this.author === '') {
               this.$store.commit('setMessage', 'Something is missing, did you fill in everything?')
            } else {
               let newStoryObject = {
                  title: this.title,
                  description: this.description,
                  snippet: this.$store.state.snippet,
                  author: this.author
               }
               console.log(newStoryObject)
               this.$store.dispatch('addStory', newStoryObject)
            }
         },
         created() {
            this.$store.commit('setTitle', '')
            this.$store.commit('setDescription', '')
            this.$store.commit('setAuthor', 'The one who must not be named')
      }
   }
}
</script>

<style lang="css" scoped>
</style>
