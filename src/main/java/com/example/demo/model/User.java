package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "password")
	private String password;

	@Column(name = "login")
	private String login;
	
	public void setId(long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
    
}
