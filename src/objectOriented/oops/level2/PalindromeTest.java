package objectOriented.oops.level2;

class PalindromeChecker {
    String text;

    // method for checking is string is palindrome or not
    boolean isPalindrome() {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // method for displaying result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }
}

public class PalindromeTest {
    public static void main(String[] args) {
        // creating object of class PalindromeChecker
        PalindromeChecker p = new PalindromeChecker();

        // assigning values
        p.text = "BOB";

        // calling display method
        p.displayResult();

        // reassinging values
        p.text = "JOB";

        // calling display method
        p.displayResult();
    }
}

