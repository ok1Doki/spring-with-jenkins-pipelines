package ua.okidoki.springaws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.okidoki.springaws.entity.User;
import ua.okidoki.springaws.repository.UserRepository;

@SpringBootApplication
public class SpringAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAwsApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(UserRepository repository) {
        return (args) -> {
            repository.save(new User("user@gmail.com", "John", "Smith", "+3806712345678"));
            repository.save(new User("pitt@gmail.com", "Bred", "Pitt", "+3806787654321"));
        };
    }

}
