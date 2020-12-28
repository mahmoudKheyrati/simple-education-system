import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class College {
    private String name;
    private List<Lecture> collegeLectures = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecture> getCollegeLectures() {
        return collegeLectures;
    }

    public boolean addLecture(Lecture lecture){
        return collegeLectures.add(lecture);
    }
    public boolean removeLecture(Lecture lecture){
        return collegeLectures.remove(lecture);
    }

    public boolean changeUnitOfLecture(Lecture lecture, int newUnit) {
        int index = collegeLectures.indexOf(lecture);
        if (index < 0 ) throw new NoSuchElementException("this college don't have this lecture");

        lecture.setUnit(newUnit);
        collegeLectures.remove(index);
        collegeLectures.add(index, lecture);
        return collegeLectures.get(collegeLectures.size() - 1) == lecture;
    }
}
