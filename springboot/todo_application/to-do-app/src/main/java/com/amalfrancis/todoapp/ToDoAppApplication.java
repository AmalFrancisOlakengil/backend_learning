package com.amalfrancis.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amalfrancis.data.post.tasks.tasks;

import jakarta.validation.Valid;

import com.amalfrancis.data.Get.tasks.valtask;
import java.util.*;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/* What are @ annotations, these are abstractions of boilerplate and XML code
That once had to be set for each to class to make it work according to its config. 
Now its abstracted away with @*/

class data{
	private Integer id;
	private String name;
	private String content;
	public data(Integer id, String name, String content){
		this.id = id;
		this.name = name;
		this.content = content;
	}
	public String getdata(){
		return "name: "+name+"\n"+"content: "+content;
	}
	public Integer getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getContent(){
		return content;
	}
}


@SpringBootApplication
/* Sets the configuration for the class that will be the entry point for spring boot.*/
@RestController
/* combination of two annotation 
   @controller and @responsebody. therefore it does both of its job. 
   @controller sets the configuration for restful api connections and @responsebody 
   sets config for endpoints to handle requests with https body return */
public class ToDoAppApplication { 
	private int id = 1;
	private ArrayList<data> memstorage = new ArrayList<>();
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

	@GetMapping("/gettask")
	public String findtask(valtask task) {
		String name = null;
		String content = null;
		for (data data : memstorage) {
			if(task.getId() != null && task.getId().equals(data.getId())){
				name = data.getName();
				content = data.getContent();
			}
			else if(task.getName() != null && task.getName().equals(data.getName())){
				name = data.getName();
				content = data.getContent();
			}
			else if(task.getContent() != null && task.getContent().equals(data.getContent())){
				name = data.getName();
				content = data.getContent();
			}
		}

		return "name:"+name+"\n"+"content:"+content;
	}

	@PostMapping("/addtask")
	public String postMethodName(@RequestBody @Valid tasks task) {
		data obj = new data(id++, task.getName(), task.getContent());
		memstorage.add(obj);
		return "Data added";
	}
	

}
