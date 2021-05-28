package com.erickisee.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FileUpload {
  
	
	public static void main(String[] args) {
	SpringApplication.run(FileUpload.class, args);
	}
	
}

