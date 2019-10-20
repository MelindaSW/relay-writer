import Vue from 'vue'
import Router from 'vue-router'

import StartGreeting from '../components/StartGreeting.vue'
import NewStory from '../components/NewStory.vue'
import PickStory from '../components/PickStory.vue'
import EditStory from '../components/EditStory.vue'
import ThankYou from '../components/ThankYou.vue'


Vue.use(Router)

export default new Router({
   routes: [{
      component: StartGreeting,
      path: '/'
   },{
      component: NewStory,
      path: '/startanewstory'
   },{
      component: PickStory,
      path: '/pickastory'
   },{
      component: EditStory,
      path: '/editstory/:title',
      name: 'editstory'
   },{
      component: ThankYou,
      path: '/thankyou'
   }]
})