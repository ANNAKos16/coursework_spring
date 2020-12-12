<template>
    <div>
        <div class="sec-block">
        <h1>Our projects</h1>

            <div v-for="game in games" :key="game.id">
                <div class="game-card">
                    <div class="game-info">
                        <h3>{{game.title}}</h3>
                        <p style="width: 95%; ">{{game.description}}</p>
                        <b-button :href="gotoLink(game)" class="primary-button">More about project</b-button>
                    </div>
                    <div class="game-image" style="width: 120%;">
                        <img style="width: 100%;" :src="game.image"/>
                    </div>
                </div>
            </div> 
        </div>
    </div>
</template>

<script>
export default {
    name: 'gamesBlock',

    props:{
        games: Array

    },

    data(){
        return{

        }
    },

    methods:{

        gotoLink(game){
            return game.link;
        }

    }
}
</script>