package edu.miu.cs.cs425.eregistrar.eregistrarapp;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Role;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.User;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.service.EregistrarUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    EregistrarUserDetailsService eregistrarUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<User> usersList = new ArrayList<>(Arrays.asList(
                new User("Alex", "Dylan", "Joe", "alex.admin",this.passwordEncoder.encode("admin"),"alex.admin@miu.edu" ),
                new User("Joy", "Phillip", "Moore", "j.moore",this.passwordEncoder.encode("student"),"joy.phillip@miu.edu" )));
        List<Role> admin = new ArrayList<>(Arrays.asList(new Role("ROLE_ADMIN")));
        List<Role> student = new ArrayList<>(Arrays.asList(new Role("ROLE_USER")));
        usersList.get(0).setRoles(admin);
        usersList.get(1).setRoles(student);

        eregistrarUserDetailsService.saveUsers(usersList);
    }
}
