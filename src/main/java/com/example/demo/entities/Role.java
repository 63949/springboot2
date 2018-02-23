package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
public class Role {
    @Id
    private String name;
    @ManyToMany(mappedBy = "roles") // 没有加mappedBy生成两个中间表,加了mappedBy生成一个中间表,指定了mappedBy的这个对象如何和另一个对象的哪个字段发生联系
//    @ManyToMany
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}
