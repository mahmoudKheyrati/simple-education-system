import java.util.ArrayList;

public class Professor extends Person{
    ArrayList<Term> terms = new ArrayList<>();

    public Professor(String name, ArrayList<College> relatedColleges, ArrayList<String> jobTitles) {
        super(name, relatedColleges, jobTitles);
    }

}
