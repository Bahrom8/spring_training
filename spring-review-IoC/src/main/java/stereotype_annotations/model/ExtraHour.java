package stereotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class ExtraHour {

    public Integer getHours(){
        return 10;
    }


}

/*
7-Create ExtraHours class inside the model package
    8-Create a method getHours() - that return 10 (int)
    9-use this method inside the DataStructure class to increase the total hours
    10-Try to use lombok annotations for creating constructor
 */
