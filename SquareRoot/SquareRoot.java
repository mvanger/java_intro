import java.util.Scanner;

public class SquareRoot {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("What number would you like to take the square root of?");
    int inputNumber = in.nextInt();
    System.out.println("What would you like the error bound to be?");
    double inputError = in.nextDouble();
    double guess = (double) inputNumber / 2;
    double test = computeBabylonianRoot(inputNumber, guess, inputError);
    int test2 = computeStartingNumber(inputNumber);

    System.out.println(test2);
  }

  public static double computeBabylonianRoot(int square, double estimate, double error) {
    double result = (estimate + (square / estimate)) / 2.0;
    return result;
  }

  public static int computeStartingNumber(int square) {
    int length = Integer.toString(square).length();
    int startingEstimate = 2;
    if (length % 2 == 0) {
      int iterations = (length - 2) / 2;
      startingEstimate = 3 * startingEstimate;
      for (int i = 1; i <= iterations; i++) {
        startingEstimate = startingEstimate * 10;
      }
    } else {
      int iterations = (length - 1) / 2;
      for (int i = 1; i <= iterations; i++) {
        startingEstimate = startingEstimate * 10;
      }
    }
    return startingEstimate;
  }
}