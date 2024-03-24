package stereotype_annotations;

import bean_practice.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.StereotypeConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.Microservice;

public class StereotypeApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(StereotypeConfig.class);

        DataStructure dataStructure = container.getBean(DataStructure.class);
        dataStructure.getTotalHours();

        Microservice microservice = container.getBean(Microservice.class);
        microservice.getTotalHours();





    }



}
