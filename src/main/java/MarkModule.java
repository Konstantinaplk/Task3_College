import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MarkModule {

    private Module module;
    private List<AchievedMark> achievedMarks;
    private double tempMark;

    public MarkModule(Module module) {
        this.module = module;
        this.achievedMarks = new ArrayList<>();
    }

    public void addAchievedMarks (AchievedMark a){
        achievedMarks.add(a);
    }

    public int getTempMark(){
        return achievedMarks
                .stream()
                .mapToInt(AchievedMark::getMark)
                .max()
                .orElse(0);
    }


}
