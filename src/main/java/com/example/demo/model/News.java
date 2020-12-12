package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "`title`")
	private String title;

	@Column(name = "description_1")
    private String description_1;

    @Column(name = "header")
    private String header;
    
    @Column(name = "description_2")
    private String description_2;

    @Column(name = "`date`")
    private String date;
    
    @Column(name = "photo")
    private String photo;

    public News(){
        
    }

    public News(String title, String description_1, String header, String description_2, String date, String photo){
        this.title=title;
        this.description_1=description_1;
        this.header=header;
        this.description_2=description_2;
        this.date=date;
        this.photo=photo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription_1(String description_1) {
        this.description_1 = description_1;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription_1() {
        return description_1;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription_2() {
        return description_2;
    }

    public String getDate() {
        return date;
    }

    public String getPhoto() {
        return photo;
    }

}
