import java.util.Scanner;

public class SquareRoot {
  public static void main(String[] args)
  {
    promptUser("y");
  }

  public static double[] computeBabylonianRoot(int square, double[] estimateIterations, double error) {
    double iterations = estimateIterations[1] + 1;
    double[] newEstimate = {(estimateIterations[0] + (square / estimateIterations[0])) / 2.0, iterations};
    double newError = computeError(square, newEstimate[0]);
    if (newError > error && newError > 0) {
      double[] answer = computeBabylonianRoot(square, newEstimate, error);
      return answer;
    } else if (newError < 0 && newError * -1 > error) {
      double[] answer = computeBabylonianRoot(square, newEstimate, error);
      return answer;
    } else {
      return newEstimate;
    }
  }

  public static double computeError(int square, double estimate) {
    double actualRoot = Math.sqrt(square);
    double newError = (estimate - actualRoot) / actualRoot;
    return newError;
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

  public static String promptUser(String input) {
    if (input.equals("y")) {
      Scanner in = new Scanner(System.in);
      System.out.println("What number would you like to take the square root of?");
      if (!in.hasNextInt()) {
        System.out.println("Error, starting over.");
        promptUser("y");
      } else {
        int beginSquare = in.nextInt();
        System.out.println("Within what relative error?");
        if (!in.hasNextDouble()) {
          System.out.println("Error, starting over.");
          promptUser("y");
        } else {
          double beginError = in.nextDouble();
          int startingEstimate = computeStartingNumber(beginSquare);
          double[] arr = {startingEstimate, 0};
          double[] test = computeBabylonianRoot(beginSquare, arr, beginError);
          System.out.println("The answer is " + test[0]);
          System.out.println("It took " + test[1] + " iterations.");
          System.out.println("Compute another? (y/n)");
          String newUserInput = in.next();
          promptUser(newUserInput);
        }
      }
    } else if (input.equals("n")) {
      System.out.println("Goodbye!");
    } else {
      System.out.println("Error, shutting down.");
    }
    return "";
  }
}