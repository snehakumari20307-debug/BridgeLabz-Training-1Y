import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] freq = new int[10];  // 0 to 9 digits

        int temp = Math.abs(num);  // handle negative numbers

        // Count frequency of digits
        while (temp != 0) {
            int digit = temp % 10;
            freq[digit]++;
            temp = temp / 10;
        }

        // Display frequency
        System.out.println("\nDigit Frequencies:");

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " occurs " + freq[i] + " times");
            }
        }

        sc.close();
    }
}