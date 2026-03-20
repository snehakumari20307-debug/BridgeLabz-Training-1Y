
    import com.gla.college.student.Student;
import com.gla.college.faculty.Faculty;

    public class MainClass{
        public static void main(String[] args) {

            Student s = new Student("Rahul", 101);
            Faculty f = new Faculty("Dr. Sharma", "Mathematics");

            s.displayStudent();
            System.out.println();
            f.displayFaculty();
        }
    }

