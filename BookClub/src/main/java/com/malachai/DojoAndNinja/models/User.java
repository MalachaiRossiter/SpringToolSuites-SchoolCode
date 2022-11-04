package com.malachai.DojoAndNinja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required")
	@Size(min=3, max=30, message="Username isn't the correct size")
	private String username;
	
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=3, max=126, message="The password must be a lot of characters please")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirming your password is required")
	@Size(min=3, max=128, message="It must be an amount of characters please")
	private String confirmpassword;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	
}
