<template>
<b-card no-body class="member-card">
                        <b-card-header header-tag="header" role="tab">
                            <b-button block  v-b-toggle = " 'accordion-' + indexObj.id " variant="info">{{indexObj.main}}</b-button>
                        </b-card-header>
                        <b-collapse :id= " 'accordion-' + indexObj.id" accordion="my-accordion" role="tabpanel">
                                <b-card-body>
                                    <div class="member-info">
                                        <div class="circle">
                                         <img :src="elementPhoto()"/>
                                        </div>
                                        <div class="info">
                                            <h3>{{indexObj.name}}</h3>
                                            <h4 style="font-size: 16px;">{{indexObj.position}}</h4>
                                            <div class="social-media">
                                                <a href="#"><img src="../../assets/github.svg"></a>
                                                <a href="#"><img src="../../assets/tg.svg"></a>
                                                <a href="#"><img src="../../assets/inst.svg"></a>
                                            </div>
                                            <p style="color: #3D4F8E; padding: 16px 0 4px 0; margin: 0;">Skills</p>
                                            <h5>{{indexObj.skills}}</h5>
                                        </div>
                                    </div>
                                    <div class="quote">
                                        <img src="../../assets/polygon.svg" id="poly1"/>
                                        <img src="../../assets/polygon.svg" id="poly2"/>
                                        <img src="../../assets/polygon.svg" id="poly3"/>
                                        <img src="../../assets/polygon.svg" id="poly4"/>
                                        <p>{{indexObj.opinion}}</p>
                                    </div>
                                </b-card-body>
                        </b-collapse>
                </b-card>
    
</template>

<script>
export default {
    props: {
        indexObj: Object,
    },
    data(){
        return{

        }
    },
    methods: {
        elementPhoto(){
            return this.indexObj.image;
        }
    },
}
</script>
<style scoped>

</style>