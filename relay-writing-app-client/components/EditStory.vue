<template lang="html">
   <div class="">
      <h1 class="title is-uppercase has-text-centered"> {{ this.$store.state.title }} </h1>
      <div class="subtitle has-text-centered">
         {{ this.$store.state.description }}
      </div>
      <!-- Visa alla tidigare inlägg här med author och submitdate bredvid -->
      <div id="snippetsdisplay" v-if="snippets.length > 0">
         <div v-for="(snippet, index) in snippets">
            <p> {{ snippet.snippet }} </p>
            <aside class="">
               <em>
                  By: {{ snippet.author }} Submitted: {{ snippet.submitdate }}
               </em>
            </aside>
         </div>
      </div>

      <snippet-textarea snippet-editor-label="Continue the story here"></snippet-textarea>

      <div class="field">
         <legend class="legend">
            Sign your name here or be anonymous
         </legend>
         <div class="control">
            <input class="input" type="text" size="40" v-model="author" placeholder="Author">
         </div>
      </div>

      <input class="button is-dark" @click="submitTheSnippet" type="button" value="Submit the snippet">

      <div class="has-text-centered">
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
         snippets() {
            return this.$store.state.storySnippets
         },
         author: {
            get() {
               return this.$store.state.author
            },
            set(author) {
               this.$store.commit('setAuthor', author)
            }
         },
         message() {
            return this.$store.state.message
         }
      },
      created() {
         this.$store.dispatch('getStorySnippets', this.$store.state.storyId)
         this.$store.commit('setSnippet', '')
         this.$store.commit('setAuthor', 'Anonymous')
         this.$store.commit('setMessage', '')
      },
      data() {
         return {
         }
      },
      methods: {
         submitTheSnippet() {

            if (this.$store.state.snippet === '' || this.author === '') {
               this.$store.commit('setMessage', 'Something is missing, did you fill in everything?')
            } else {
               let newSnippetObject = {
                  snippet: this.$store.state.snippet,
                  author: this.author
               }
               this.$store.commit('setMessage', 'Thank you for your contribution!')
               console.log(newSnippetObject)
               console.log(this.$store.state.storyId)
                  // this.$store.commit('setNewStory', newStoryObject)
               this.$store.dispatch('addSnippet', newSnippetObject)
            }
         }
      }
   }
</script>

<style lang="css" scoped>

   /* #snippetsdisplay {
      border: dotted 1.5rem white;
      padding: 2rem;
   } */

</style>
