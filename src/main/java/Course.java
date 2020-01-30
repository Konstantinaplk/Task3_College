import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {

    private String Name;
    private String location;
    private Cohort cohort;



    public Course(String name, String location, Cohort cohort) {
        Name = name;
        this.location = location;
        this.cohort = cohort;
    }
}
