<template>
    <div class="sec-block">
        <h1>New in gameblog</h1>

        <div>
            <vue-horizontal-list 
            :items="items" 
            :options="options">
                <template v-slot:default="{item}">
                    <div style="margin-right:32px;" class="bg-steam border-6 overflow-hidden flex">
                        <div class="ImageBoxed">
                            <img style="object-fit: cover; width:100%; height:240px;" src="../../assets/news.jpg"/>
                        </div>
                        <div class="p-16-24">
                        <router-link  style="background-color: #00000000; padding:0;" 
                        :to="{path: '/newPage/'+ item.id, query: {item: item}}" >
                            <h5 class="text-ellipsis-1l">
                                {{item.title}}</h5></router-link>
                        
                            <p class="text-ellipsis-2l">{{item.description_1.substr(0, 160) + '...'}}</p>
                        </div>
                    </div>
                </template>
            </vue-horizontal-list>
        </div>
        
    </div>
</template>
<script>

import VueHorizontalList from './VueHorizontalList';

export default {

    name: 'newsBlock',

    components:{
        VueHorizontalList
    },

    data(){
        return{            
            options: {
                item: {
                    class: '',
                    padding: 12 
                },
                list: {
                class: '', 
                    windowed: 1200,
                    padding: 24
                },
                responsive: [
                    {end: 576, size: 1}, 
                    {size: 2}
                ],
            } 
        }
    },

    props:{
        items: Array,
    },

    methods:{

        getItem(item){
            console.log(item);
        }
        
    },
    
}
</script>