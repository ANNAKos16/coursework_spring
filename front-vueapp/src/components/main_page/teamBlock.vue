<template>
    <div class="sec-block" style="padding-top: 0;">
        <h1>Our team</h1>

            <div class="accordion" role="tablist" v-for="item in members" :key="item.id">
                <team-member :indexObj='item' >
                        <!-- <b-card-header header-tag="header" role="tab">
                            <b-button block  v-b-toggle = " 'accordion-' + index.id " variant="info">{{index.main}}</b-button>
                        </b-card-header>
                        <b-collapse :id= " 'accordion-' + index.id" accordion="my-accordion" role="tabpanel">
                                <b-card-body>
                                    <div class="member-info">
                                        <div>
                                         <img style="width: 100%;" :src="elementPhoto(index)"/>
                                        </div>
                                        <div class="info">
                                            <h3>{{index.name}}</h3>
                                            <h4 style="font-size: 16px;">{{index.position}}</h4>
                                            <div class="social-media">
                                                <a href="#"><img src="../../assets/github.svg"></a>
                                                <a href="#"><img src="../../assets/tg.svg"></a>
                                                <a href="#"><img src="../../assets/inst.svg"></a>
                                            </div>
                                            <p style="color: #3D4F8E; padding: 16px 0 4px 0; margin: 0;">Skills</p>
                                            <h5>{{index.skills}}</h5>
                                        </div>
                                    </div>
                                    <div class="quote">
                                        <img src="../../assets/polygon.svg" id="poly1"/>
                                        <img src="../../assets/polygon.svg" id="poly2"/>
                                        <img src="../../assets/polygon.svg" id="poly3"/>
                                        <img src="../../assets/polygon.svg" id="poly4"/>
                                        <p>{{index.opinion}}</p>
                                    </div>
                                </b-card-body>
                        </b-collapse> -->
                </team-member>
        </div>
        
    </div>
</template>

<script>
import teamMember from './teamMember'
export default {
    name: 'teamBlock',
    components: {
        teamMember
    },

    data(){
        return{
            str: '', 
        }
    },

    props:{
        members: Array
    },

    methods:{
    },
    
}
</script>