import java.util.Scanner;
import java.util.Arrays;

public class DynamicDigitArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int maxDigit = 5; // initial size
        int[] digits = new int[maxDigit];
        int index = 0;

        while (num != 0) {

            // If array is full, increase size
            if (index == maxDigit) {
                maxDigit = maxDigit * 2;
                int[] temp = new int[maxDigit];

                // copy old array into new array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp; // assign new array
            }

            digits[index] = num % 10;
            num = num / 10;
            index++;
        }

        // Find largest and second largest digit
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);

        sc.close();
    }
}