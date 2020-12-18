<template>
    <div>
        <b-modal style="background-color: #000618" body-bg-variant="dark" ref="adminModal" hide-footer title="Entry to Admin panel">
 <div class="form" style="width: 100%; background: none;">
     <b-container>
                <b-row> <label>Login</label>
                    <b-form-input v-model="login"></b-form-input>
                </b-row>
                <b-row>
                    <label>Password</label>
                    <b-form-input v-model="password"></b-form-input>
                </b-row>
                <b-row>
                    <p v-if="logflag" style="text-align: center; padding: 8px 32px 0px 32px;">IF YOU DON'T KNOW THE PASSWORD, YOU ARE NOT ADMIN! GO AWAY!!!</p>
                </b-row>
                <b-row>
                    <b-button  v-on:click="postLogin"
                    style="margin: 2rem 0 0 0 ;" 
                    class="primary-button">Log in</b-button>
                </b-row>
     </b-container>
            </div>
        </b-modal>
    </div>
</template>
<script>

import AdminDataService  from "../services/AdminDataService";

export default {
    
    name: "adminPopup",

    data(){
        return{
            logflag: false,
            login: '',
            password: ''
        }
    },

    mounted(){
        this.showModal();
    },

    methods:{
        showModal(){
            this.$refs['adminModal'].show()
        },

        hideModal(){
            this.$refs['adminModal'].hide()
        },

        postLogin(){
            AdminDataService.findUser(this.password)
            .then(response =>{
                console.log(response.data);
                if(response.data[0].password==this.password){
                    this.logflag=false;
                    console.log("trolololo");
                    this.$router.push('/adminpanel')
                }
                else{
                    this.logflag=true;
                }
            })
            .catch(e =>{
                this.logflag=true;
                console.log(e);
            });
        },
    }
}
</script>