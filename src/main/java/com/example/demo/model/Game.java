package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
    private String description;
    
    @Column(name = "link")
    private String link;
    
    @Column(name = "image")
	private String image;

	public Game() {

    }
    
    public Game(String title, String description, String link, String image) {
        this.title=title;
        this.description = description;
        this.link=link;
        this.image=image;
    }
    
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
