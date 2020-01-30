package com.example.demo.service;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void addTask(Task task, Optional<User> optional){
    	if(optional.isPresent()) {
    		task.setUser(optional.get());
    	}
        taskRepository.save(task);
    }

    public List<Task> findUserTask(Optional<User> user){
        return taskRepository.findByUser(user);
    }
}
