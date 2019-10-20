<template>
   <div class="">
      <label class="label" for="snippeteditor"> {{ snippetEditorLabel }} </label>
      <textarea class="textarea" @keyup="triggerCounter" name="snippeteditor" rows="8" cols="80" maxlength="350" style="resize: none" v-model="snippet"></textarea>

      <div id="counter">
         {{ this.remainingCharacters }} / {{ this.maxCharacters }}
      </div>

   </div>
</template>

<script>
   export default {
      computed: {
         snippet: {
            get() {
               return this.$store.state.snippet
            },
            set(snippet) {
               this.$store.commit('setSnippet', snippet)
            }
         }
      },
      data() {
         return {
            maxCharacters: 350,
            remainingCharacters: 350
         }
      },
      methods: {
         triggerCounter() {
            this.remainingCharacters = this.maxCharacters - this.snippet.length;
         }
      },
      props: {
         snippetEditorLabel: {
            type: String,
            default: 'Write something'
         }
      }
   }
</script>

<style lang="css" scoped>
</style>
