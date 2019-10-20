import Vue from 'vue'
import App from '../components/App.vue'
import store from './store.js'
import router from './router.js'
import '../style/index.scss'

new Vue ({
   el: '#app',
   render: h => h(App),
   router,
   store
})
