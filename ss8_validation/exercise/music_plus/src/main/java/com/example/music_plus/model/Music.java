package com.example.music_plus.model;

import com.example.music_plus.utils.annotation.RegexCharConstraint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "music_model")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @RegexCharConstraint
    @NotEmpty(message = "Chưa nhập tên bài hát")
    @Size(min = 10,max = 800,message = "Ít nhất 10 và tối đa 800 kí tự")
    private String name;
    @RegexCharConstraint
    @NotEmpty(message = "Chưa nhập tên ca sĩ")
    @Size(min = 10,max = 300,message = "Ít nhất 10 và tối đa 300 kí tự")
    private String singer;

    @NotEmpty(message = "Chưa nhập thể loại nhạc")
    @Size(min = 10,max = 1000,message = "Ít nhất 10 và tối đa 1000 kí tự")
    private String type;

    private String path;

    public Music() {
    }

    public Music(Integer id, String name, String singer, String type, String path) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
