package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "team_members")
public class Member {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "links")
    private String links;
    
    @Lob
    @Column(name = "photo")
    private String image;
    
    @Column(name = "position")
    private String position;
    
    @Column(name = "skills")
    private String skills;
    
    @Column(name = "opinion")
    private String opinion;

    @Column(name = "main")
    private String main;



    Member(){

    }

    Member( String title, String links, 
    String image, String position, String skills, String opinion, String main){
        this.title=title;
        this.links=links;
        this.image=image;
        this.position=position;
        this.skills=skills;
        this.opinion=opinion;
        this.main=main;
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public String getLinks() {
        return links;
    }

    public String getImage() {
        return image;
    }

    public String getPosition() {
        return position;
    }

    public String getSkills() {
        return skills;
    }

    public String getOpinion() {
        return opinion;
    }

    public String getMain() {
        return main;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.title = name;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setMain(String main) {
        this.main = main;
    }
    
}
