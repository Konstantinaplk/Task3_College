import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CollegeTest {
    private Student student;
    private College college;
    private Course course1;
    private Module module1;
    private AchievedMark achievedMark1;
    private AchievedMark achievedMark2;
    private MarkModule markModule;

    private Student student2;
    private College college2;
    private Course course12;
    private Module module12;
    private AchievedMark achievedMark12;
    private AchievedMark achievedMark22;
    private MarkModule markModule2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        student = new Student();
        college = new College();

        course1 = new Course("Maths", "code.hub", Cohort.SEPT_2019_JUN_2020);
        module1 = new Module("algebra", course1, "Bob", ModuleType.MANDATORY);
        achievedMark1 = new AchievedMark(new Date(90,1,23), 5);
        achievedMark2 = new AchievedMark(new Date(90,5,25), 7);
        markModule = new MarkModule(module1);
        markModule.addAchievedMarks(achievedMark1);
        markModule.addAchievedMarks(achievedMark2);
        student.setCourse(course1);
        student.addMarkModules(markModule);
        college.addStudent(student);

        student2 = new Student();
        course12 = new Course("ComputerS", "code.hub", Cohort.SEPT_2019_JUN_2020);
        module12 = new Module("java", course1, "Bob", ModuleType.MANDATORY);
        achievedMark12 = new AchievedMark(new Date(90,1,23), 7);
        achievedMark22 = new AchievedMark(new Date(90,5,25), 9);
        markModule2 = new MarkModule(module12);
        markModule2.addAchievedMarks(achievedMark12);
        markModule2.addAchievedMarks(achievedMark22);
        student2.setCourse(course12);
        student2.addMarkModules(markModule2);
        college.addStudent(student2);



    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addStudent() {
        college.addStudent(student);
        assertEquals(true, college.addStudent(student), "error in adding");
    }

    @org.junit.jupiter.api.Test
    void calculateStudentsAvgMarks() {
        assertEquals(8, college.calculateStudentsAvgMarks(college), "wrong total avg");
    }

    @org.junit.jupiter.api.Test
    void saveStudentsToCSVFile() {
        try {
            college.saveStudentsToCSVFile("CSVfile");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void saveAsXML() throws FileNotFoundException {
//        try {
//            college.saveAsXML("CSVfile.xml");
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
        assertEquals(true, college.saveAsXML("xmlFile"));
    }
}