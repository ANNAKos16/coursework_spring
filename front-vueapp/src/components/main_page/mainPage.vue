<template>
    <div>
        <div class='navbar'>
            <ul class='navbar1'>
                <li id="first-nav" class="lll active"
                @click.prevent='scrollTo("home")'><a>Home</a></li>
                <li class="lll" @click.prevent='scrollTo("news")'><a>Blog</a></li>
                <li class="lll" @click.prevent='scrollTo("games")'><a>Games</a></li>
                <li class="lll" @click.prevent='scrollTo("team")'><a>Our team</a></li>
                <li class="lll" @click.prevent='scrollTo("form")'><a>Looking for!</a></li>
            </ul>
        </div>
        <div id='home' class="main-block">
            <img  src="@/assets/main_logo.svg">
            <h4 >Good solutions for your entertainment!</h4>
            <b-button class="primary-button" @click.prevent='scrollTo("team")'>More about team</b-button>
        </div>
        <news-block id='news' :items="news"></news-block>
        <games-block id='games' :games="games"></games-block>
        <team-block id='team' :members="members"></team-block>
        <reviews-block id='form'></reviews-block>

        <div class="sec-block footer">
            <img src="@/assets/footer_logo.svg">
        </div>
    </div>
</template>

<script>

import GameDataService from "../../services/GameDataService";
import MemberDataService from "../../services/MemberDataService";
import NewsDataService from"../../services/NewsDataService"

import newsBlock from "./newsBlock.vue"
import gamesBlock from "./gamesBlock.vue"
import teamBlock from "./teamBlock.vue"
import reviewsBlock from "./reviewsBlock"


export default {

    name: "mainPage",

    components:{
        newsBlock,
        gamesBlock,
        teamBlock,
        reviewsBlock
    },

    data(){
        return{
            games:[],
            members: [],
            news:[],
        }
    },

    created(){
        this.getGames();
        this.getMembers(); 
        this.getNews();
    },

    methods:{
        scrollTo(idLink){
            let scrollEl = document.getElementById(idLink);
            scrollEl.scrollIntoView({block: 'start', behavior: 'smooth'});
        },

        getGames(){
            GameDataService.getAll()
            .then(response =>{
                this.games=response.data;
            })
            .catch(e =>{
                console.log(e);
            });
        },

        getNews(){
            NewsDataService.getAll()
            .then(response =>{
                this.news=response.data;
            })
            .catch(e =>{
                console.log(e);
            });
        },

        getMembers(){
            let cont=this;
            MemberDataService.getAll()
            .then(response =>{
                cont.members=response.data;
            })
            .catch(e =>{
                console.log(e);
            });
        },
        
    },
    
}
</script>
<style scoped>

#first-nav{
    list-style:  url('../../assets/firstnav.svg');
    height: 22px;
}

</style>