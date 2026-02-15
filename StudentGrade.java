import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = sc.nextDouble();

            System.out.print("Chemistry: ");
            chemistry[i] = sc.nextDouble();

            System.out.print("Maths: ");
            maths[i] = sc.nextDouble();

            // Check for negative marks
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Marks cannot be negative. Enter again.");
                i--; // repeat same student
                continue;
            }

            // Calculate percentage
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;

            // Assign grade
            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
        }

        // Display Result
        System.out.println("\n---- Student Report ----");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        sc.close();
    }
}