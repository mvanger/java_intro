import java.util.Scanner;

public class FactorialRecursion {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("What number to factorialize?");
    int number = in.nextInt();
    int answer = recursiveFactorial(number);
    System.out.println("The answer is " + answer);
  }

  public static int recursiveFactorial(int input)
  {
    int result = 1;
    if (input > 1) {
      result = input * recursiveFactorial(input - 1);
    }
    return result;
  }
}