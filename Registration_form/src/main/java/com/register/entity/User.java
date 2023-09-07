package com.register.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	public User(int userId, String name, String username, String password, String gender, String dob,
			List<String> technology) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.technology = technology;
	}

	public User() {
		super();
		this.userId = 0;
		this.name = null;
		this.username = null;
		this.password = null;
		this.gender = null;
		this.dob = null;
		this.technology = null;
	}
	public int getUserId() {
		return userId;
	}

;
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public List<String> getTechnology() {
		return technology;
	}


	public void setTechnology(List<String> technology) {
		this.technology = technology;
	}


	private String name;
	private String username;
	private String password;
	private String gender;
	private String dob;
	

	@ElementCollection(targetClass=String.class)
	private List<String> technology;

}
