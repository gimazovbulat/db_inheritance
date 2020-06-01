package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.dto.UserDto;
import ru.itis.services.interfaces.AdminsService;
import ru.itis.services.interfaces.UsersService;

@SpringBootApplication
public class Main implements ApplicationRunner {
    @Autowired
    UsersService usersService;

    @Autowired
    AdminsService adminsService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Users:");
        System.out.println("findAll. \n" + usersService.findAll());
        System.out.println("findByName: asd \n" + usersService.findByName("asd"));
        System.out.println("findById: 1 \n" + usersService.findById(1L));
        System.out.println("-------------------------------");
        System.out.println("Admins:");
        System.out.println("findAll. \n" + adminsService.findAll());
        System.out.println("findByName: kujuhykju \n" + adminsService.findByName("kujuhykju"));
        System.out.println("findById: 3 \n" + adminsService.findById(3L));
        System.out.println(usersService.save(new UserDto("new", 21) ));
    }
}
