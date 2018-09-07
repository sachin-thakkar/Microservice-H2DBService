package com.example.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("/{name}")
	public List<String> getQuotes(@PathVariable("name") final String name) {
		return studentRepo.findByName(name).stream().map(Student::getPassportNumber).
		collect(Collectors.toList());	
	}
}
