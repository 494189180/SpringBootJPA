package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ename;

    public User() {
    }

    public User(String name, String ename) {
        this.name = name;
        this.ename = ename;
    }

    @Override
    public String toString() {
        /*
          JAVA字符串格式化-String.format()
          %s 字符串类型  %d 整数类型（十进制）
         */
        return String.format("Customer[id=%d, name='%s', ename='%s']",id,name,ename);
    }
}
