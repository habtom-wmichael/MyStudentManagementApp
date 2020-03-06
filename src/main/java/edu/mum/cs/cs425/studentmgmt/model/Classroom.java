package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="classroomTable")
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "classroom_id")
	private int classroomId;

	@Column(name = "building_name", nullable = false)
	private String buildingName;

	@Column(name = "room_number", nullable = false)
	private String roomNumber;

	@OneToMany(mappedBy = "classroom")
	private List<Student> students = new ArrayList<>();

	public Classroom() {
	}

	public Classroom(String buildingName, String roomNumber) {
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Classroom(int classroomId, String buildingName, String roomNumber, List<Student> students) {
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.students = students;
	}
	public void addStudent(Student s) {
		students.add(s);
		s.setClassroom(this);
		
	}

}
