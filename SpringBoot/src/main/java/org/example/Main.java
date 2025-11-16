package org.example;


import org.example.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(IUserRepository repository) {
        return args -> {
//            UserEntity user = new UserEntity();
//            user.setUsername("admin");
//            user.setPassword("");
//            repository.save(user);
//            UserEntity saved = repository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        };
    }
}