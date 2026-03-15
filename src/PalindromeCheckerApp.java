import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Palindrome Checker - UC13");
        System.out.println(" Performance Comparison");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Char Array Method
        long start1 = System.nanoTime();
        boolean result1 = charArrayPalindrome(input);
        long end1 = System.nanoTime();

        // Stack Method
        long start2 = System.nanoTime();
        boolean result2 = stackPalindrome(input);
        long end2 = System.nanoTime();

        // Deque Method
        long start3 = System.nanoTime();
        boolean result3 = dequePalindrome(input);
        long end3 = System.nanoTime();

        // Recursive Method
        long start4 = System.nanoTime();
        boolean result4 = recursivePalindrome(input, 0, input.length() - 1);
        long end4 = System.nanoTime();

        System.out.println("\n--- Results ---");
        System.out.println("Char Array Result : " + result1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Result      : " + result2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Result      : " + result3 +
                " | Time: " + (end3 - start3) + " ns");

        System.out.println("Recursive Result  : " + result4 +
                " | Time: " + (end4 - start4) + " ns");

        scanner.close();
    }

    // 1️⃣ Char Array Two Pointer
    public static boolean charArrayPalindrome(String input) {
        char[] arr = input.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // 2️⃣ Stack Method
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // 3️⃣ Deque Method
    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // 4️⃣ Recursive Method
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }
}