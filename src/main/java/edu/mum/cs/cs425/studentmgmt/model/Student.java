package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "studentTable")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;

	@Column(name = "student_number", nullable = false)
	private String studentNumber;

	// @NotEmpty(message = "*Required")
	@NotNull
	private String firstName;

	private String middleName;

	// @NotEmpty(message = "* required")
	@NotNull
	private String lastName;

	private double cgpa;

	@Column(name = "admision_date")
	private LocalDate dateOfEnrollment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transcript_id")
	private Transcript transcript;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Student() {

	}

	public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa,
			LocalDate dateOfEnrollment, Transcript transcript, Classroom classroom) {

		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classroom = classroom;
	}

	public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa,
			LocalDate dateOfEnrollment) {

		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;

	}

	public void setTranscript(Transcript transcript) {
		// Transcript transcript = new Transcript(title);
		this.transcript = transcript;
	}

	public void setClassroom(Classroom room) {
		this.classroom = room;
	}

	public Transcript getTranscript() {
		return this.transcript;

	}
//	public Classroom getClassroom(Classroom room) {
//		return room;
//	}
}
