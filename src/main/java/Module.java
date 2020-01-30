import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {

    private String name;
    private Course course;
    private String assignedTutor;
    private ModuleType moduletype;


}
