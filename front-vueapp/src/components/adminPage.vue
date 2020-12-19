<template>
    <div >
        <div class="header">
        <a href="/" ><img style="width: 14%; margin: 0;" src="../assets/main_logo.svg"/></a>
        </div>
        <div style="padding-top: 15%">
            <div><b-button v-on:click="createModal"
            class="primary-button">
                         Create post
                     </b-button></div>
            <b-table hover 
            :items="news" 
            :fields="newsfields">
                <template v-slot:cell(edit)="data">
                     <b-button  v-on:click="showModal(data)">
                         edit
                     </b-button>
                </template>
                <template v-slot:cell(delete)="data">
                     <b-button v-on:click="deleteNew(data)">
                         delete
                     </b-button>
                </template>
            </b-table>
        </div>

        <b-modal body-bg-variant="dark" ref="editModal" hide-footer title="Sending a message:">
            <b-container>
                <b-row style="margin: 24px 0px 0px 0px;">
            <b-form-input v-model="editNew.title" placeholder="Title"></b-form-input>
                </b-row>
                <b-row style="margin: 24px 0px 0px 0px;">
            <b-form-textarea v-model="editNew.description_1" placeholder="first description"></b-form-textarea>
            </b-row>
            <b-row style="margin: 24px 0px 0px 0px;">
            <b-form-input v-model="editNew.header" placeholder="Header"></b-form-input>
             </b-row>
                <b-row style="margin: 24px 0px 0px 0px;">
            <b-form-textarea v-model="editNew.description_2" placeholder="Second description"></b-form-textarea>
             </b-row>
            <b-row style="margin: 24px 0px 0px 0px;">
                <b-form-input v-model="editNew.photo" placeholder="Enter the photo url"></b-form-input>
            </b-row>
            <b-row style="margin: 24px 0px 0px 0px;">
                <b-form-input type="date" v-model="editNew.date" placeholder="Date of post"></b-form-input>
            </b-row>

                 <b-row style="margin: 24px 0px 0px 0px;">
                    <b-button v-if="editFlag"  style="margin: 2rem 0 0 0 ;" class="primary-button"
                    v-on:click="editNewMethod">Edit</b-button>
                    <b-button v-if="createFlag"  style="margin: 2rem 0 0 0 ;" class="primary-button"
                    v-on:click="createNews">Create</b-button>
                 </b-row>
            </b-container>
        </b-modal>
        
    </div>
</template>

<script>

import GameDataService from "../services/GameDataService";
//import MemberDataService from "../services/MemberDataService";
import NewsDataService from"../services/NewsDataService"

export default {
    
    name: "adminPanel",

    data(){
        return{
            games:[],
            members: [],
            news:[],
            createFlag: false,
            editFlag: false,

            editNew:{
                id: 0,
                title: '',
                description_1: '',
                header: '',
                description_2:'',
                photo:'',
                date: null
            },

            newsfields:[
                {
                    key: 'id',
                },
                {
                    key: 'title',
                },
                {
                    key: 'description_1',
                },
                {
                    key: 'header',
                },
                {
                    key: 'description_2',
                },
                {
                    key: 'photo',
                },
                {
                    key: 'date',
                },
                {
                    key: 'edit',
                    label: ''
                },
                {
                    key: 'delete',
                    label: ''
                },
            ]
        }
    },

    created(){
        this.getGames();
        //this.getMembers(); 
        this.getNews();
    },

    methods:{

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

        createModal(){
            this.createFlag=true;
            this.editFlag=false;
            this.$refs['editModal'].show()
        },

        createNews(){
            let cont=this;
            console.log(this.editNew);
            let new_new = {
                title: this.editNew.title,
                description_1: this.editNew.description_1,
                header: this.editNew.header,
                description_2:this.editNew.description_2,
                date: this.editNew.date,
                photo: this.editNew.photo,
            };


            NewsDataService.create(new_new)
                .then(response => {
            cont.news.push(response.data);
            console.log(response.data);
            })
                .catch(e => {
            console.log(e);
            });

        },

        deleteNew(data){
            NewsDataService.delete(data.item.id)
        .then(response => {
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        this.getNews();
        },

        showModal(data){
            this.editNew.id=data.item.id;
            this.editNew.title=data.item.title;
            this.editNew.description_1=data.item.description_1;
            this.editNew.header=data.item.header;
            this.editNew.description_2=data.item.description_2;
            this.editNew.photo=data.item.photo;
            this.editNew.date=data.item.date;
            this.createFlag=false;
            this.editFlag=true;
            this.$refs['editModal'].show()
        },

        editNewMethod(){
             let news = {
                id: this.editNew.id,
                title: this.editNew.title,
                description_1: this.editNew.description_1,
                header: this.editNew.header,
                description_2:this.editNew.description_2,
                photo: this.editNew.photo,
                date: this.editNew.date,
            };
            console.log(news.id);

            NewsDataService.update(news.id, news)
            .then(response => {
                console.log('trololololo!')
            console.log(response.data);
            })
            .catch(e => {
                console.log('blallala')
            console.log(e);
            });
            this.hideModal();
            
        },

        hideModal(){
            this.$refs['editModal'].hide();
            this.getNews();
        }

    }
}
</script>