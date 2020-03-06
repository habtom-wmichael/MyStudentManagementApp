package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "transcriptTable")
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "transcript_id")
	private long transcriptId;

	@Column(name = "degree_title")
	private String degreeTitle;

	@OneToOne(mappedBy = "transcript")
	private Student student;

	public Transcript() {
	}

	public Transcript(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

}
