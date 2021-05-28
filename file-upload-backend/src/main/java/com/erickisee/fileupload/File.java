package com.erickisee.fileupload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name ;
    private String date ;
    
    @Column(name = "fileBytes", length = 10000)
    private byte[] fileBytes ;

    public Integer getId(){
        return this.id;
    }

    public void setId (Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }
    
    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + this.id + ", \"name\":\"" + this.name + '\"' + ", \"file\":\"" + this.fileBytes + '\"' + "}";
    }
}
