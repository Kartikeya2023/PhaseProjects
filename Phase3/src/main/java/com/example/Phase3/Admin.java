package com.example.Phase3;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private Long id;
	 
	 @Column
	 private String username;
	 
	 @Column
	 private String password;

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 
	
	 
}
