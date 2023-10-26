package ro.ctrln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStartup {


    // An API that can READ, CREATE, UPDATE, DELETE an Entity (Battleship)
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartup.class, args);
    }
}
