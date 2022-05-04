package com.learning.vault.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nilakshi
 *
 */
@Entity
@Table(name="student_details")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@OneToOne(mappedBy="studentDetails",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Student student;

	public StudentDetails() {
	}

	public StudentDetails(String contactNo, String emailAddress) {
		super();
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", contactNo=" + contactNo + ", emailAddress=" + emailAddress + ", student="
				+ student + "]";
	}
}
