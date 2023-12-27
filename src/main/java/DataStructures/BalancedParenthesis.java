package DataStructures;



import java.util.Scanner;
import java.util.Stack;


public class Balanced {
    static Stack<Character> newst = new Stack<>();

    public static void checkBalance(char ch) {
        if (ch == '(') {
            newst.push(ch);
        } else if (ch == ')') {
            if (!newst.isEmpty()) {
                newst.pop();
            } else {
                throw new RuntimeException("Unmatched closing parenthesis.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an arithmetic expression:");
        String input = sc.nextLine();

        for (char ch : input.toCharArray()) {
            try {
                checkBalance(ch);
            } catch (Exception e) {
                System.out.println("Not balanced: " + e.getMessage());
                return;
            }
        }

        int s = newst.size();
        if (s == 0)
            System.out.println("Balanced");
        else
            System.out.println("Not balanced");
        sc.close();
    }

}
