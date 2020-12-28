import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Term {
    private Semester semester;
    private HashMap<Lecture,Double> lectures = new HashMap<>();

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

    public int getTotalUnit(){
        AtomicInteger units = new AtomicInteger();
        lectures.forEach((lecture, score) -> units.addAndGet(lecture.getUnit()));
        return units.get();
    }
}
