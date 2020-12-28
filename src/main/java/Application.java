import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws IllegalAccessException, ExecutionControl.NotImplementedException {
        College computerCollege = new College("Computer computerCollege");
        Professor taheri = new Professor("taheri", List.of(computerCollege), List.of("associated professor"));


        Lecture advancedProgramming = new Lecture("Advanced Programming ", 3, computerCollege, Set.of(taheri));

        computerCollege.addLecture(advancedProgramming);

        Term term = new Term();
        term.setSemester(new Semester("fall 99-1400", null, null, null, null));
        term.addLecture(advancedProgramming);

        Student mahmoud = new Student("mahmoud", List.of(computerCollege),List.of("Student"));
        mahmoud.addTerm(term);

        mahmoud.takeLecture(term, computerCollege, advancedProgramming);

        taheri.setScore(term.getSemester(), advancedProgramming, mahmoud, 20);

        System.out.println(mahmoud.getTermAverage(term));

    }
}
