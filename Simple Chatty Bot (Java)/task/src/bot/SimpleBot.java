package bot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleBot {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet("Carina", 2023);
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    static void greet(String assistantName, int birthYear) {
        System.out.printf("Hello! My name is %s.\n", assistantName);
        System.out.printf("I was created in %d.\n", birthYear);
        System.out.println("Please, remind me your name.");
    }

    static void remindName() {
        String name = scanner.nextLine();
        System.out.printf("What a great name you have, %s!\n", name);
    }

    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        try {
            int rem3 = scanner.nextInt();
            int rem5 = scanner.nextInt();
            int rem7 = scanner.nextInt();
            if (rem3 < 0 || rem3 > 2 || rem5 < 0 || rem5 > 5 || rem7 < 0 || rem7 > 6) {
                throw new ArithmeticException();
            }
            int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
            System.out.printf("Your age is %d; that's a good time to " +
                    "start programming!\n", age);
        } catch (InputMismatchException e) {
            System.out.println("Something went wrong. Let's try again.");
            scanner.nextLine();
            guessAge();
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Numbers provided do not match the " +
                    "requirements. Please, try again.");
            guessAge();
        }
    }

    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");
        int correctAnswer = 2;
        while (scanner.hasNext()) {
            try {
                int userAnswer = scanner.nextInt();
                if (userAnswer == correctAnswer) break;
                System.out.println("Please, try again.");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please, try again.");
            }
        }
    }

    static void end() {
        System.out.println("Congratulations, have a nice day!");
    }
}
