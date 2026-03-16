import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Palindrome Checker - UC13");
        System.out.println(" Strategy Pattern + Performance Comparison");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // --- Strategy 1 : Stack ---
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeService stackService = new PalindromeService(stackStrategy);

        long start1 = System.nanoTime();
        boolean stackResult = stackService.check(input);
        long end1 = System.nanoTime();

        // --- Strategy 2 : Deque ---
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        PalindromeService dequeService = new PalindromeService(dequeStrategy);

        long start2 = System.nanoTime();
        boolean dequeResult = dequeService.check(input);
        long end2 = System.nanoTime();

        System.out.println("\n--- Results ---");

        System.out.println("Stack Strategy Result : " + stackResult +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Deque Strategy Result : " + dequeResult +
                " | Time: " + (end2 - start2) + " ns");

        scanner.close();
    }
}


// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}


// Concrete Strategy 1: Stack-based
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


// Concrete Strategy 2: Deque-based
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}


// Context / Service class
class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}