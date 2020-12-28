import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

class Student extends Person{
    ArrayList<Term> terms = new ArrayList<>();

    public Student(String name, ArrayList<College> relatedColleges, ArrayList<String> jobTitles) {
        super(name, relatedColleges, jobTitles);
    }

    public ArrayList<Lecture> getCollegeLectures(College college) throws IllegalAccessException {
        if (!relatedColleges.contains(college)) {
            throw new IllegalAccessException("you are not a member of this college. so you can't get it's lectures.");
        }
        return college.getCollegeLectures();
    }

    public boolean takeLecture(College college, Lecture lecture) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("not implemented yet!");
    }

}