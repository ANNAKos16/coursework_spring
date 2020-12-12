package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "`title`")
	private String title;

	@Column(name = "email")
    private String email;

    @Column(name = "contact")
	private String contact;

	@Column(name = "description")
    private String description;

    @Column(name="`read`")
    private Boolean read;
    

    Message(){

    }

    public Message(String title, String email, String description, Boolean read){
        this.title=title;
        this.email=email;
        this.description=description;
        this.read=read;
    }

    public Message(String title, String email, String contact, String description, Boolean read){
        this.title=title;
        this.email=email;
        this.contact=contact;
        this.description=description;
        this.read=read;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getRead() {
        return read;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

}
