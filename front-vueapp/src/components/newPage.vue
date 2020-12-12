<template>
<div>
    <div class="header">
        <a href="/" ><img style="width: 14%;" src="../assets/main_logo.svg"/></a>
    </div>
    <div class="new_photo" v-if="photos"  style=" width: 100%;">
            <img style="width: 180%; margin-left: -40%;" :src="photos[0].photo_name"/>
            <h1 style="font-size: 3rem; width: 90%; ">{{currentNew.title}}</h1>
    </div>

    <div class="sec-block">
        <h1 >What is about?</h1>
        <div class="game-card">
            <div class="game-info">
                <p style="font-size: 16px;">{{currentNew.description_1}}</p>
            </div>     
            <div class="game-image">
                <img :src="photos[1].photo_name"/>
            </div>
        </div>
        <div class="new_photo" v-if="photos"  style=" width: 100%; height:60rem;">
                <img style="width: 180%; margin-left: -40%; opacity: 40%; height:100%; object-fit: cover;" :src="photos[2].photo_name"/>
                <div class="news_h3">
                    <h2 class="news_title">{{currentNew.header}}</h2>
                </div>
        </div>
        <div class="game-card" style="margin-top: 160px;">
            <div class="game-image">
                <img :src="photos[3].photo_name"/>
            </div>
            <div class="game-info" style="padding-left:24px;">
                <p style="font-size: 16px;">{{currentNew.description_2}}</p>
            </div>     
        </div>
        <div class="sec-block footer">
            <img src="@/assets/footer_logo.svg">
        </div>
    </div>
</div>    
</template>

<script>

import NewsDataService from"../services/NewsDataService"

export default {

    name: "newPage",

    props:{
        publication: Object
    },

    data(){
        return{
            currentNew: null,
            photos: [],

        }
    },
    created(){
        this.currentNew = this.$router.currentRoute.query.item;
        this.photos=this.getImages(this.currentNew.id);
    },
    mounted(){
console.log(this.photos);
        // console.log(this.publication);
        // console.log('query', this.$router.currentRoute.query.item);
    },

    methods:{
        getImages(id){
            NewsDataService.getPhotos(id)
            .then(response =>{
                this.photos=response.data;
                console.log(this.photos);
            })
            .catch(e =>{
                console.log(e);
            });
        },
    }

}
</script>