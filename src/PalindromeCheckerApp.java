import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Palindrome Checker - UC10");
        System.out.println(" Case-Insensitive & Space-Ignored");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        String normalized = input
                .replaceAll("\\s+", "")   // Remove spaces using regex
                .toLowerCase();           // Convert to lowercase

        // Step 2: Apply two-pointer logic
        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}