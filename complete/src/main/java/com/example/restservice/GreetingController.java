package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/test")
	public String test(){
		return "Hello Student";
	}

	@GetMapping("/person")
	//	http://localhost:8081/person?fName=rose&lName=jack
	public Person person(@RequestParam(value = "fName") String fName,
						 @RequestParam(value = "lName") String lName){

		return new Person(fName,lName);
	}

	@PostMapping("/person")
	//	http://localhost:8081/person
	public String createPerson(@RequestBody Person person){
		System.out.println(person);
		return "person is created";
	}

	@GetMapping("/employee")
	public Employee employee(@RequestParam(value = "idNumber") int id,
							 @RequestParam(value = "name") String name,
							 @RequestParam(value = "job") String jobTitle){
		return new Employee(id,name,jobTitle);
	}

	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employee employee){
		System.out.println(employee);
		return "employee is created";
	}




}
