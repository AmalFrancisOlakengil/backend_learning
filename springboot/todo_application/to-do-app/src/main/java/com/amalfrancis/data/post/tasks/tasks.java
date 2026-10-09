package com.amalfrancis.data.post.tasks;
import jakarta.validation.constraints.*;

public class tasks {
    
    @NotBlank 
    private String name;

    @NotBlank 
    private String content;

    public tasks(){}

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
