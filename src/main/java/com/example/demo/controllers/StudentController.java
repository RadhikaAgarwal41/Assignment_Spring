package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;

@RestController    ///this class serves as the controller for requests
public class StudentController {
	
	@GetMapping("/home")  //Url Mapping
	public String home()
	{
		return "welcome";
	}
     
	@Autowired
	public StudentRepository studentRepository;
	
	
	
	@GetMapping("/read")
	public List<Student> getAllStudents(){
		try {
		return studentRepository.findAll();
		} 
		catch(Exception e) {
			System.out.println(e);
			List<Student> l=new LinkedList<>();
			return l;
		}
	}
	@GetMapping("/read/{id}")
	public Student read(@PathVariable Long id) {  //@Pathvariable annotation is used to extract the template part of the url
		try {
		Optional<Student> Obj = studentRepository.findById(id);
		if(Obj.isPresent()) {
			return Obj.get();
		}else {
			throw new RuntimeException("Student not found with id "+id);
		}
		}
		catch(Exception e) {
			Student l=new Student();
			l.setFname("NOT FOUND");
			l.setLname("NOT FOUND");
			l.setBranch("NOT FOUND");
			l.setCollege("NOT FOUND");
			l.setDob("NOT FOUND");
			l.setAge(000000);
			l.setID(0);
			System.out.println(e);
			return l;
		}
	}
	
	@PostMapping("/create")
	public String createStudent(@RequestBody Student student){	//maps the http request body to domain object
		
		
		try {
			studentRepository.insert(student);
			return "Created Student";
		}
		catch(Exception e) {
			return "eRROR";
		}
	}
	@PutMapping("/update")
	public String update(@RequestBody Student modifiedObject) {
		try {
		 studentRepository.save(modifiedObject);
		 return "done";
		}
		catch(Exception e){
			return "error";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		try {
		Optional<Student> studentobj = studentRepository.findById(id);
		if(studentobj.isPresent()) {
			studentRepository.delete(studentobj.get());
			return "Student deleted with id "+id;
		}else {
			throw new RuntimeException("Student not found for id "+id);
		}
		}
		catch(Exception e) {
			return "error";
		}
	}
		 
}
