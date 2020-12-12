package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "news_photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_photo;
    
    @Column(name = "photo_name")
    private String photo_name;
    
    @Column(name = "idnew")
    private Integer idnew;
    
    @Column(name = "photo_description")
    private String photo_description;
    
    public Photo(){

    }

    public Photo(String photo_name, Integer idnew, String photo_description){

        this.photo_name=photo_name;
        this.idnew=idnew;
        this.photo_description=photo_description;
    }

    public void setId(long id_photo) {
        this.id_photo = id_photo;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public void setIdnew(Integer idnew) {
        this.idnew = idnew;
    }

    public void setPhoto_description(String photo_description) {
        this.photo_description = photo_description;
    }

    public long getId() {
        return id_photo;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public Integer getIdnew() {
        return idnew;
    }

    public String getPhoto_description() {
        return photo_description;
    }
    
}
