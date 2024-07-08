package com.attech;

import com.attech.role.Role;
import com.attech.role.RoleRepository;
import com.attech.role.UserRole;
import com.attech.user.User;
import com.attech.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class TaskManagementBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TaskManagementBackendApplication.class, args);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		Role role = seedRole(roleRepository);
		User user = seedAdmin(role);
		User admin = userRepository.save(user);

		System.out.println("Application started successfully.");
		System.out.println("Application name: " + context.getEnvironment().getProperty("spring.application.name"));
		System.out.println( "Base URL: "+ context.getApplicationName());
		System.out.println("Active profile is: " + context.getEnvironment().getProperty("spring.profiles.active"));
		System.out.println("Admin user is: " + admin.getFirstName() + " " + admin.getLastName());
	}

	private static User seedAdmin(Role role) {

		System.out.println("+++++++++++++++ SEEDING USER +++++++++");
		return  User.builder()
				.firstName("Almu")
				.lastName("Tukur")
				.email("atumar4031@gmail.com")
				.phone("07066616752")
				.status("ENABLED")
				.roles(Set.of(role))
				.build();


	}

	public static Role seedRole(RoleRepository repository){

		System.out.println("+++++++++++++++ SEEDING ROLE +++++++++");
		Optional<Role> roleAdmin = repository.findByRole(UserRole.ADMIN);
		if (roleAdmin.isEmpty()){
			Role role = Role.builder()
					.role(UserRole.ADMIN)
					.description("THis role is for system admin")
					.build();
			return repository.save(role);
		}else {
			return roleAdmin.get();
		}
	}
}
