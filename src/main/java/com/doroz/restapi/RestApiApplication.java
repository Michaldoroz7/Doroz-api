package com.doroz.restapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner userTest(UserRepository repository){
        return args -> {
            //Testing save in DB
            repository.save(new User("User1", "123", "testowymail@gmail.com", 123321123 ));
            repository.save(new User("User2", "a123", "jakismail@gmail.com", 189537345 ));
            repository.save(new User("User3", "b123", "kolejnymail@gmail.com", 774839343 ));

            //Print all users
            for (User user : repository.findAll()){
                System.out.println("Login: " + user.getLogin());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone Number: " + user.getPhoneNumber());
            }

        };
    }
}
