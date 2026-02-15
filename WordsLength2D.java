import java.util.Scanner;

public class WordsLength2D {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] splitText(String text) {
        int len = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) if (text.charAt(i) == ' ') wordCount++;

        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < len; i++) if (text.charAt(i) == ' ') spaceIndexes[idx++] = i;

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end = (i < wordCount - 1) ? spaceIndexes[i] : len;
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) word.append(text.charAt(j));
            words[i] = word.toString();
            start = end + 1;
        }
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] table = wordsWithLengths(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }
        sc.close();
    }
}
