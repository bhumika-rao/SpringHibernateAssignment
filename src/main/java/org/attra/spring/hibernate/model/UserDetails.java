package org.attra.spring.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
/*
 * This is our model class and it corresponds to USER_DETAILS table in database
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails{
 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int userId;
 
	@Column(name="name")
	String name; 
 
	@Column(name="email")
	String email;
	
	@Column(name="errormessage")
	String errormessage;
	
	@Column(name="solution")
	String solution;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", email="
				+ email + ", errorMessage=" + errormessage +", solution="+solution+ "]";
	}

	
 
}