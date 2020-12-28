import java.util.Date;

public class Semester {
    private String name;
    private Date startDate;
    private Date endDate;
    private Date finalExamsStart;
    private Date finalExamsEnd;

    public Semester(String name, Date startDate, Date endDate, Date finalExamsStart, Date finalExamsEnd) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalExamsStart = finalExamsStart;
        this.finalExamsEnd = finalExamsEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getFinalExamsStart() {
        return finalExamsStart;
    }

    public void setFinalExamsStart(Date finalExamsStart) {
        this.finalExamsStart = finalExamsStart;
    }

    public Date getFinalExamsEnd() {
        return finalExamsEnd;
    }

    public void setFinalExamsEnd(Date finalExamsEnd) {
        this.finalExamsEnd = finalExamsEnd;
    }
}
