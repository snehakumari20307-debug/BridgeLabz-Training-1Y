import java.util.Scanner;

public class CharFrequencyCharAt {

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII characters
        int n = text.length();

        // Count frequency of each character using charAt()
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters to size the 2D array
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) uniqueCount++;
        }

        // Create 2D array [character, frequency]
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] frequencies = findFrequency(text);

        System.out.println("Character frequencies:");
        System.out.printf("%-10s%-10s%n", "Character", "Frequency");
        for (String[] row : frequencies) {
            System.out.printf("%-10s%-10s%n", row[0], row[1]);
        }

        sc.close();
    }
}
