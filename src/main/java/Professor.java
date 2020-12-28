import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Professor extends Person {
    ArrayList<Term> terms = new ArrayList<>();

    public Professor(String name, List<College> relatedColleges, List<String> jobTitles) {
        super(name, relatedColleges, jobTitles);
    }

    public List<Lecture> getCollegeLectures(College college) throws IllegalAccessException {
        if (!relatedColleges.contains(college)) {
            throw new IllegalAccessException("you are not a member of this college. so you can't get it's lectures.");
        }
        return college.getCollegeLectures();
    }

    public boolean takeLecture(Term term, College college, Lecture lecture) throws ExecutionControl.NotImplementedException, IllegalAccessException {
        if (!relatedColleges.contains(college)) {
            throw new IllegalAccessException("you are not a member of this college");
        }
        int index = relatedColleges.indexOf(college);
        if (!relatedColleges.get(index).getCollegeLectures().contains(lecture)) {
            throw new IllegalAccessError("this college don't have this lecture");
        }

        int termIndex = terms.indexOf(term);
        if (termIndex < 0) {
            throw new IllegalAccessException("this term doses'nt exits! ");
        }

        return terms.get(termIndex).addLecture(lecture);
    }

    public ArrayList<Student> getAllStudents() {
        return null;
    }

    public boolean setScore(Semester semester, Lecture lecture, Student student, double score) throws IllegalAccessException {
        var studentTerm = student.getTerms()
                .stream()
                .filter(term -> term.getSemester() == semester)
                .collect(Collectors.toList()).get(0);
        if (!studentTerm.getLectures().containsKey(lecture)) {
            throw new IllegalAccessException("this student don't have this lecture");
        }
        Lecture lecture1 = studentTerm.getLectures().keySet().stream()
                .filter(it -> it.getProfessors().contains(this))
                .collect(Collectors.toList()).get(0);
        if (lecture1 == null) {
            throw new IllegalAccessException("this don't have this lecture with you!");
        }

        studentTerm.getLectures().put(lecture1, score);
        return true;

    }

}
