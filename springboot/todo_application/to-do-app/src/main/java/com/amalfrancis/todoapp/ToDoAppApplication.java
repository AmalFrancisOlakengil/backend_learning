package com.amalfrancis.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amalfrancis.data.Get.tasks.tasks;

/* What are @ annotations, these are abstractions of boilerplate and XML code
That once had to be set for each to class to make it work according to its config. 
Now its abstracted away with @*/
@SpringBootApplication
/* Sets the configuration for the class that will be the entry point for spring boot.*/
@RestController
/* combination of two annotation 
   @controller and @responsebody. therefore it does both of its job. 
   @controller sets the configuration for restful api connections and @responsebody 
   sets config for endpoints to handle requests with https body return */


public class ToDoAppApplication { 
	/*  this is considered as a bean, a java object that
		completely managed by springboot application, therefore
		ToDoAppApplication objects are managed by springboot.
	*/
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	/* simple get method configured here which returns hello world in default
	This is a single query parameter method*/
	@GetMapping("/")
    public String helloworld() {
      return "Application is successfully running";
    }

	@GetMapping("/task")
	public String findtask(tasks task) {
		return "id: "+ task.getId()+"\n"+"name: "+task.getName()+"\n"+"content:" + task.getContent();
	}
	


}
