<template>
<!-- <div class=""> -->
<router-view></router-view>
<!-- </div> -->
</template>

<script>
   import StartGreeting from './StartGreeting.vue'
   import NewStory from './NewStory.vue'
   import PickStory from './PickStory.vue'
   import EditStory from './EditStory.vue'
   import ThankYou from './ThankYou.vue'

   export default {
      components: {
         'start-greeting': StartGreeting,
         'new-story': NewStory,
         'pick-story': PickStory,
         'edit-story': EditStory,
         'thank-you': ThankYou
      }
   }
</script>

<style lang="css">

</style>
