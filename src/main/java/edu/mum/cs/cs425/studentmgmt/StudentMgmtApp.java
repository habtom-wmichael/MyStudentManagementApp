package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner{
	@Autowired
private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);	
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Classroom classroom= new Classroom("McLaughlin building", "M105");
		Transcript trans=new Transcript("BS Computer Science");
		
	Student std= new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
	
	Student std1= new Student("000-61-0002", "Habtom", "Yadu", "Hossie", 3.45, LocalDate.of(1990, 6, 23));
	
	classroom.addStudent(std);
	classroom.addStudent(std1);
	std.setTranscript(trans);
	List<Student> students=Arrays.asList(std,std1);
	students.forEach(s->saveStudent(std));
		//saveStudent(std);
		
	}

public  void saveStudent(Student std) {
	studentRepository.save(std);
}
}
