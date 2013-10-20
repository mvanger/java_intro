/**
  Author:
  Purpose: This program computes a number's square root using the Babylonian method.
  General Design: Four methods make up the program. promptUser gets input from the user and runs the computations.
  computeStartingNumber computes the number to use at the start of the algorithm. computeBabylonianRoot runs the
  algorithm. computeError computes the error between the estimate and the actual square root.
*/
import java.util.Scanner;

public class SquareRoot {
  public static void main(String[] args)
  {
    promptUser("y");
  }

  /**
    Computes the estimate of the square root. It recursively calls itself until the error bounds are met.
    @params square is the number of which to estimate the square root, estimateIterations is an array of the estimate
    and the number of iterations, and error is the error bound entered by the user.
    @return the array of the estimate and the number of iterations.
  */
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

  /**
    Computes the error of the estimate and the actual square root.
    @params square is the number of which to take the square root. estimate is the current estimate.
    @return the error between the estimate and actual square root.
  */
  public static double computeError(int square, double estimate) {
    double actualRoot = Math.sqrt(square);
    double newError = (estimate - actualRoot) / actualRoot;
    return newError;
  }

  /**
    Computes the starting number for the Babylonian method.
    @param square is the number of which to take the square root.
    @return the starting estimate
  */
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

  /**
    Gets user input and calls the algorithm. It recursively calls itself as long as the user inputs "y".
    @param input is whether the user wants to run the algorithm or exit the program
    @return void
  */
  public static void promptUser(String input) {
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
          double[] inputArray = {startingEstimate, 0};
          double[] test = computeBabylonianRoot(beginSquare, inputArray, beginError);
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
  }
}