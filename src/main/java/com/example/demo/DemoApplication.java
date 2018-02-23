package com.example.demo;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

/*		User user = new User("lpz@163.com", "lpz", "1233");
		Task task = new Task("2000-10-10", "18:00:00", "19:00:00", "go super");
		taskRepository.save(task);*/
		/*task.setUser(user);
		List listTask = new ArrayList();
		listTask.add(task);
		user.setTasks(listTask);
		userRepository.save(user);*/
	}


	@Override
	public void run(String... strings) throws Exception {
		User newAdmin = new User("admin@163.com","admin","123456");
		userService.createAdmin(newAdmin);
	}
}
