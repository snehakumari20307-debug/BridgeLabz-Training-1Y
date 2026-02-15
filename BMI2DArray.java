import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] data = new double[n][3]; 
        // Column 0 = Height
        // Column 1 = Weight
        // Column 2 = BMI

        // Input height and weight
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter height (in meters): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter weight (in kg): ");
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI
        for (int i = 0; i < n; i++) {
            data[i][2] = data[i][1] / (data[i][0] * data[i][0]);
        }

        // Display Result
        System.out.println("\n---- BMI Report ----");

        for (int i = 0; i < n; i++) {

            String status;

            if (data[i][2] < 18.5)
                status = "Underweight";
            else if (data[i][2] < 25)
                status = "Normal";
            else if (data[i][2] < 30)
                status = "Overweight";
            else
                status = "Obese";

            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + data[i][0] + " m");
            System.out.println("Weight: " + data[i][1] + " kg");
            System.out.println("BMI: " + data[i][2]);
            System.out.println("Status: " + status);
        }

        sc.close();
    }
}