import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Lecture {
    private String name;
    private int unit;
    private College college;
    private Set<Professor> professors;

    public Lecture(String name, int unit, College college, Set<Professor> professors) {
        this.name = name;
        this.unit = unit;
        this.college = college;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public boolean addProfessor(Professor professor) {
        return professors.add(professor);
    }

    public boolean deleteProfessor(Professor professor) {
        // validation for the lecture don't have professor
        return professors.remove(professor);
    }
}
