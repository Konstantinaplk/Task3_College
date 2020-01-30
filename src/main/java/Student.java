import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class Student {

    private Course course;
    private List<MarkModule> markModules;

    public Student() {
//        course = this.course;
        this.markModules = new ArrayList<MarkModule>();
    }

    public Student(Course course) {
        this.course = course;
    }

    public void addMarkModules(MarkModule m){
        markModules.add(m);
    }

    public void enrollModule(Module m){
        if (m.getCourse() == course){
            markModules.add(new MarkModule(m));
        }
        else {
            System.out.println("Cannot enroll in this Module");
        }
    }


    public double getAvgMark(){
        if(!markModules.isEmpty() ) {
            return (markModules
                    .stream()
                    .mapToDouble(MarkModule::getTempMark)
                    .sum())/markModules.size();

//            MarkModule.getAch.maptoInt.max
        }
        else {
            return 0;
        }

//        if(!markModules.isEmpty() ) {
//            return (markModules
//                    .stream()
//                    .map(MarkModule::getAchievedMarks(markModules)::max);
//
////            MarkModule.getAch.maptoInt.max
//        }
//        else {
//            return 0;
//        }
    }

    public boolean checkIfAllModulesPassed(){
        boolean k = true;
        for (int i = 0;i<=markModules.size();i++){
            if (markModules.get(i).getTempMark() <=5){
                k = false;
                System.out.println("Haven't pass: " + markModules.get(i).getModule());
            }
        }
        return k;
    }


}
