

public class TestRecursion {
    public static void main(String[] args) {
        try {
            Recursion recursion = new Recursion();

            System.out.println("Factorial of 5: " + recursion.factorial(5));
            System.out.println("Factorial of 0: " + recursion.factorial(0));

            System.out.println("Fibonacci of 6: " + recursion.fibonacci(6));
            System.out.println("Fibonacci of 1: " + recursion.fibonacci(1));

            try {
                recursion.factorial(-1);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected error for negative factorial: " + e.getMessage());
            }

            System.out.println("TestRecursion completed successfully");
        } catch (Exception e) {
            System.out.println("Error in TestRecursion: " + e.getMessage());
        }
    }
}