import Vue from 'vue'
import App from './App.vue'
import router from './router'

import './assets/main.css';
import './assets/buttons.css';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'


Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')