<template>
    <div class="sec-block">
        <h1>Will cooperate?</h1>
        
        <div class="feedback">
            <div>
                <div class="point">
                    <img src="../../assets/point.svg"/>
                    <h5>Do you have good skills
                    in game-design or producing?</h5>
                </div>
                <div class="point">
                    <img src="../../assets/point.svg"/>
                    <h5>Do you ambitious artist
                        in 2D/3D?</h5>
                </div>
                <div class="point">
                    <img src="../../assets/point.svg"/>
                    <h5>Do you programmer who needs creativity?</h5>
                </div>
            </div> 
            <div class="form">
                <b-row> <label>What's your name?</label>
                    <b-form-input v-model="message.title"></b-form-input>
                </b-row>
                <b-row>
                    <b-col style="padding-right: 24px;">
                        <label>Give us your email, please...</label>
                        <b-form-input v-model="message.email"></b-form-input>
                    </b-col>
                    <b-col>
                        <label>And your Telegram, Inst or VK</label>
                         <b-form-input v-model="message.contact"></b-form-input>
                    </b-col>
                </b-row>
                <b-row>
                    <label>Please, tell more detailed about it)  Thanks!</label>
                    <b-form-textarea v-model="message.description"></b-form-textarea>
                </b-row>
                <b-row>
                    <b-button  v-on:click="postMessage"
                    style="margin: 2rem 0 0 0 ;" 
                    class="primary-button">Start to communicate!</b-button>
                </b-row>
            </div>
        </div>

        <b-modal body-bg-variant="dark" ref="messageModal" hide-footer title="Sending a message:">
            <div class="d-block text-center">
                <h4>{{submitting_text}}</h4>
            </div>
            <b-button variant="primary" block 
            v-on:click="hideModal">Ok!</b-button>
        </b-modal>

    </div>
</template>

<script>

import MessageDataService from "../../services/MessageDataService"

export default {

    name: "reviewsBlock",

    props:{

    },
    
    data(){
        return{
            message:{
            title: '',
            email:'',
            contact: '',
            description:'',
            },
            submitted: false,
            submitting_text:'',
        }
    },

    methods:{

        postMessage(){

            let cont=this;

            MessageDataService.create(cont.message)
                .then(response => {
                this.message.id = response.data.id;
                console.log(response.data);
                this.submitted = true;
                cont.message={
                    title: '',
                    email:'',
                    contact: '',
                    description:'',
                };
                cont.submitting_text="Message sent successfully!"
                cont.showModal();
                })
                .catch(e => {
                console.log(e);
                cont.submitting_text="Sorry, something went wrong ... Write to 1 of the proposed contacts."
                cont.showModal();
            });
        },

        showModal(){
            this.$refs['messageModal'].show()
        },

        hideModal(){
            this.$refs['messageModal'].hide()
        }
        
    },
    
}
</script>