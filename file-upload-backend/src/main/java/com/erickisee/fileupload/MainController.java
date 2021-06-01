package com.erickisee.fileupload;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@Controller 
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/file") 
public class MainController {
  @Autowired 
  private FileRepository fileRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam("name") String name
  ,@RequestParam("date") String date,@RequestParam("file") MultipartFile file) throws IOException {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    File newFile = new File();
    newFile.setName(name);
    newFile.setDate(date);
    newFile.setFileBytes(file.getBytes());

    System.out.println("--\n\n\n-----\n\n file bytes length is \n\n\n"  + file.getBytes().length );

    fileRepository.save(newFile);
    return newFile.toString();
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<File> getAllFiles() {
    // This returns a JSON or XML with the users
    return fileRepository.findAll();
  }

  @PutMapping(path="/update/{id}")
  public @ResponseBody String updateById(@PathVariable int id, @RequestBody File newFile ) {
      
    fileRepository.save(newFile);
    
    return newFile.toString();
  }

  @DeleteMapping(path="/delete/{id}")
  public @ResponseBody String deleteById (@PathVariable int id){
      fileRepository.deleteById(id);
      File deletedFile = new File();
      deletedFile.setId(id);
      return deletedFile.toString();
  }

}