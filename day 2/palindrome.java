import java.util.Scanner;

public class palindrome {
    static final int MOD = 1000000007;

    public static int shortPalindrome(String s) {
        int n = s.length();
        long result = 0;

        long[] count1 = new long[26];            // frequency of single chars
        long[][] count2 = new long[26][26];      // frequency of ab
        long[] count3 = new long[26];            // frequency of abb seen so far

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            // Add abba ending at this char
            result = (result + count3[c]) % MOD;

            // Build abb ending at this char
            for (int j = 0; j < 26; j++) {
                count3[j] = (count3[j] + count2[j][c]) % MOD;
            }

            // Build ab pairs
            for (int j = 0; j < 26; j++) {
                count2[j][c] = (count2[j][c] + count1[j]) % MOD;
            }

            // Update frequency of single char
            count1[c]++;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        System.out.println(shortPalindrome(s));
        scanner.close();
    }
}
