import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Term {
    private Semester semester;
    private HashMap<Lecture,Double> lectures;

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public HashMap<Lecture, Double> getLectures() {
        return lectures;
    }


    public boolean addLecture(Lecture lecture) {
        lectures.put(lecture, 0.0);
        return true;
    }

    public double getTermAverage(){
        AtomicReference<Double> sumOfScores = new AtomicReference<>(0.0D);
        lectures.forEach((lecture, score) ->{
            sumOfScores.updateAndGet(v -> v + lecture.getUnit() * score);
        });

        return sumOfScores.get()/getTotalUnit();
    }

    public int getTotalUnit(){
        AtomicInteger units = new AtomicInteger();
        lectures.forEach((lecture, score) -> units.addAndGet(lecture.getUnit()));
        return units.get();
    }
}
