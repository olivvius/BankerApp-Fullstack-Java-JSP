package fr.m2i.spring;

import static ch.qos.logback.core.util.StatusPrinter.print;
import fr.m2i.spring.Service.ClientService;
import fr.m2i.spring.Service.LinesService;
import fr.m2i.spring.Service.RoleService;
import fr.m2i.spring.Service.UserService;
import fr.m2i.spring.exception.duplicateEmailException;
import fr.m2i.spring.model.Client;
import fr.m2i.spring.model.Lines;
import fr.m2i.spring.model.Role;
import fr.m2i.spring.model.User;
import fr.m2i.spring.repository.LinesRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Equivalent de
// @SpringBootConfiguration
// @EnableAutoConfiguration
//@ComponentScan(basePackages = {"fr.m2i.spring.lesson", "fr.m2i.data"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws duplicateEmailException {

        //demarrage de l'application
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        //appel des beans
        LinesService lineService = ctx.getBean(LinesService.class);
        ClientService clientService = ctx.getBean(ClientService.class);
        LinesRepository linesRepository = ctx.getBean(LinesRepository.class);
        UserService userService = ctx.getBean(UserService.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        
        //creation des clients
        Client client1 = new Client("Dupont", "Albert", "19 rue de la croix rousse", "69004", "Lyon", "0699887744", "albert@gmail.com");
        Client client2 = new Client("Casas", "Michael", "25 rue de Denfert", "69005", "Lyon", "0633221155", "casas@gmail.com");

        //m2i.getPrestation().add(presta);
        clientService.create(client1);
        clientService.create(client2);

        //creation des lignes de comptes
        Lines line1 = new Lines(150.00);
        Lines line2 = new Lines(-301.50);
        Lines line3 = new Lines(210.00);
        Lines line4 = new Lines(-50.75);    

        line1.setClient(client1);
        line2.setClient(client1);
        line3.setClient(client2);
        line4.setClient(client2);

        lineService.create(line1);
        lineService.create(line2);
        lineService.create(line3);
        lineService.create(line4);
        //creation des users
        User user1 = new User("Alfred", "Mortimer", "alfred@gmail.com", "admin");
        User user2 = new User("John", "Duff", "john@gmail.com", "admin");
        userService.create(user1);
        userService.create(user2);
        
        /*
        List<Lines> lignes = linesRepository.findByClient(client1);
        
        for(int i=0;i<lignes.size();i++){
            System.out.println(lignes.get(i).getMontant());
        }
        */
        
        /*
        // System.out.println(userService.isEmailUnique("john@gmail.com"));
        //User administrator = new User("Admin", "admin", "admin@gmail.com", "admin");

        //Role roleAdmin = new Role("ROLE_ADMIN");
       // Role roleUser = new Role("ROLE_USER");
        //roleService.create(roleAdmin);
        roleService.create(roleUser);

        List<Role> rolesAdmin = new ArrayList<>();
        //rolesAdmin.add(roleAdmin);
        rolesAdmin.add(roleUser);

        List<Role> rolesUser = new ArrayList<>();
        rolesUser.add(roleUser);

       // administrator.setRoles(rolesAdmin);
        user1.setRoles(rolesUser);
         */

        //userService.create(administrator);
    }
}
