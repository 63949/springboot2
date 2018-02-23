package com.example.demo.service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public void createRole(Role role){
//        Role userRole = new Role("USER1");
/*        List<Role> roles = new ArrayList<>();
        roles.add(role);*/

/*        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User("lpz@163.com","zzz","123456");
        List<User> users = new ArrayList<>();
        users.add(user);
        role.setUsers(users);*/

   /*     ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);*/
        roleRepository.save(role);
    }
}
