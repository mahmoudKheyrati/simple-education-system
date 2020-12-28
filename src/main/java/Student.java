import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

class Student extends Person{
    List<Term> terms = new ArrayList<>();

    public Student(String name, List<College> relatedColleges, List<String> jobTitles) {
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
        if (termIndex<0) {
            throw new IllegalAccessException("this term doses'nt exits! ");
        }

        return terms.get(termIndex).addLecture(lecture);
    }

    public double getTermAverage(Term term) throws IllegalAccessException {
        if (!terms.contains(term)){
            throw new IllegalAccessException("you don't have this term");
        }
        var lectures = terms.stream().filter(term1 -> term1 == term).collect(Collectors.toList()).get(0).getLectures();
        AtomicReference<Double> sumOfScores = new AtomicReference<>(0.0D);
        lectures.forEach((lecture, score) ->{
            sumOfScores.updateAndGet(v -> v + lecture.getUnit() * score);
        });

        return sumOfScores.get()/term.getTotalUnit();
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void addTerm(Term term) {
        terms.add(term);
    }
}