import java.util.Objects;

public class Lecture {
    private String name;
    private int unit;
    private College college;

    public Lecture(String name, int unit, College college) {
        this.name = name;
        this.unit = unit;
        this.college = college;
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
}
