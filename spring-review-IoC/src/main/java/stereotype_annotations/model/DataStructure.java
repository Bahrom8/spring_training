package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataStructure {

    private ExtraHour extraHour;


    public void getTotalHours(){
        System.out.println("Total hours " + (45 + extraHour.getHours()));
    }



}
