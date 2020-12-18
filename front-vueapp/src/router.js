import Vue from "vue";
import Router from "vue-router";

import mainPage from './components/main_page/mainPage.vue'
import newPage from './components/newPage.vue'
import adminPopup from './components/adminPopup.vue'
import adminPage from './components/adminPage.vue'

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    // {
    //   path: "/",
    //   alias: "/tutorials",
    //   name: "tutorials",
    //   component: () => import("./components/TutorialsList")
    // },
    {
      path: "/tutorials/:id",
      name: "tutorial-details",
      component: () => import("./components/Tutorial")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddTutorial")
    },
    {
      path: '/',
			component: mainPage,
			name: "Главная"
    },
    {
      path: '/newPage/:id',
			component: newPage,
      name: "Новости",
      props: true,
    },
    {
      path: '/admin',
			component: adminPopup,
      name: "adminPopup"
    },
    
    {
      path: '/adminpanel',
			component: adminPage,
      name: "adminPage"
		},

  ]
});