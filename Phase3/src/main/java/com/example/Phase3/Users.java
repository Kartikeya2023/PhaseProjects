package com.example.Phase3;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
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
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
    
}
