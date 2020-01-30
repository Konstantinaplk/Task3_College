import lombok.Data;
import org.json.simple.JSONArray;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class College {

    private List<Student> students;

    public College() {
        this.students = new ArrayList<Student>();
    }

    public boolean addStudent(Student student){
        students.add(student);
        return true;
    }

    public double calculateStudentsAvgMarks(College c){
        double sum = 0;
        for (int i = 0; i < c.getStudents().size(); i++){
            sum += c.getStudents().get(i).getAvgMark();
        }
        if (c.getStudents().size()!=0) {
            double v = (double) sum / c.getStudents().size();
            return v;
        }
        else {
            return 0;
        }
    }

    public void saveStudentsToCSVFile(String filename)
        throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File(filename));

        for (Student s : students){
            pw.println(s.getCourse() + ";" + s.getAvgMark());
        }
        pw.close();
    }

    public boolean saveAsXML(String filename) throws FileNotFoundException {
        XMLEncoder encoder = null;
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));

        encoder.writeObject(students);
        encoder.close();
        return true;
    }

    public String createJson(){
        JSONArray jsArray = new JSONArray();
        jsArray.addAll(students);
        return jsArray.toString();
    }

}
