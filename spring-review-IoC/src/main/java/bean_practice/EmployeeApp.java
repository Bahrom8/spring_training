package bean_practice;

import bean_practice.practice.FullTimeEmployee;
import bean_practice.practice.PartTimeEmployee;
import bean_practice.config.AppConfig;
import bean_practice.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class, StringConfig.class);
        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);

        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();

        String Cydeo = container.getBean("Cydeo",String.class);
        String Practice = container.getBean("Practice",String.class);
        System.out.println(Cydeo);
        System.out.println(Practice);




    }

}
