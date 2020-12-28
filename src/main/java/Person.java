import java.util.ArrayList;

public class Person {
    String name;
    ArrayList<College> relatedColleges;
    ArrayList<String> jobTitles;
    String lastJobTitle;

    public Person(String name, ArrayList<College> relatedColleges, ArrayList<String> jobTitles) {
        if (jobTitles.isEmpty()){
            throw new IllegalArgumentException(
                    "we can't have person without jobTitle\n" +
                    "each person should have at least one job title");
        }
        if (relatedColleges.isEmpty()){
            throw new IllegalArgumentException("each person should have at least one related college");
        }

        this.name = name;
        this.relatedColleges = relatedColleges;
        this.jobTitles = jobTitles;
        this.lastJobTitle = jobTitles.get(jobTitles.size() -1);
    }

    public String getName() {
        return name;
    }

    public ArrayList<College> getRelatedColleges() {
        return relatedColleges;
    }

    public ArrayList<String> getJobTitles() {
        return jobTitles;
    }

    public String getLastJobTitle() {
        return jobTitles.get(jobTitles.size() -1);
    }

    public boolean addJobTitle(String jobTitle){
        jobTitles.add(jobTitle);
        lastJobTitle = jobTitles.get(jobTitles.size() - 1);
        return lastJobTitle.equals(jobTitle);
    }

    public boolean removeJobTitle(String jobTitle){
        // we can't have person Without jobTitle
        if (jobTitles.size() ==1 ){
            return false;
        }
        return jobTitles.remove(jobTitle);
    }

    public boolean addRelatedCollege(College college){
        return relatedColleges.add(college);
    }

    public boolean removeCollege(College college) {
        // we can't have user without college in the system
        if (relatedColleges.size() ==1){
            return false;
        }
        return relatedColleges.remove(college);

    }

}