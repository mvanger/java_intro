/**
  Author:
  Purpose: This program computes a number's square root using the Babylonian method.
  General Design: Four methods make up the program. promptUser gets input from the user and runs the computations.
  computeStartingNumber computes the number to use at the start of the algorithm. computeBabylonianRoot runs the
  algorithm. computeError computes the error between the estimate and the actual square root.
*/
import java.util.Scanner;
import java.util.ArrayList;

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
    Asks the user for the relative error they want.
    @param none
    @return the user-specified relative error
  */
  public static double getRelativeError() {
    Scanner secondIn = new Scanner(System.in);
    System.out.println("Within what relative error?");
    double relativeError;
    if (!secondIn.hasNextDouble()) {
      System.out.println("Error, starting over.");
      relativeError = getRelativeError();
    } else {
      relativeError = secondIn.nextDouble();
      if (relativeError <= 0) {
        System.out.println("Error must be positive.");
        relativeError = getRelativeError();
      }
    }
    return relativeError;
  }

  /**
    Asks the user what output style they want
    @param none
    @return the user-specified output style (1 or 2)
  */
  public static int getOutputStyle() {
    Scanner thirdIn = new Scanner(System.in);
    System.out.println("What would you like the output to look like?");
    System.out.println("\t1) All on one line");
    System.out.println("\t2) One at a time");
    int outputStyle;
    if (!thirdIn.hasNextInt()) {
      System.out.println("Please enter 1 or 2.");
      outputStyle = getOutputStyle();
    } else {
      outputStyle = thirdIn.nextInt();
      if (outputStyle != 1 && outputStyle != 2) {
        System.out.println("error is here");
        System.out.println("Please enter 1 or 2.");
        outputStyle = getOutputStyle();
      }
    }
    return outputStyle;
  }

  /**
    Gets user input and calls the algorithm. It recursively calls itself as long as the user inputs "y".
    @param input is whether the user wants to run the algorithm or exit the program
    @return void
  */
  public static void promptUser(String input) {
    if (input.equals("y")) {
      Scanner in = new Scanner(System.in);
      System.out.println("What numbers would you like to take the square root of?");
      System.out.println("You may enter them one at a time, or the entire sequence separated by spaces.");
      System.out.println("Only positive integers will be recorded.");
      System.out.println("Enter a non-numeric value to submit.");
      // Initializes ArrayList
      ArrayList<Integer> startingIntegers = new ArrayList<Integer>();
      // Populates ArrayList
      while (in.hasNextInt()) {
        int beginSquare = in.nextInt();
        if (beginSquare > 0) {
          startingIntegers.add(beginSquare);
        }
      }
      // Gets relative error and output style from user
      double relativeErrorInput = getRelativeError();
      int style = getOutputStyle();
      // Computes square root for elements in ArrayList
      for (int square : startingIntegers) {
        int startingEstimate = computeStartingNumber(square);
        double[] inputArray = {startingEstimate, 0};
        double[] test = computeBabylonianRoot(square, inputArray, relativeErrorInput);
        if (style == 1) {
          System.out.print("For " + square + ", the answer is " + test[0]);
          System.out.print(". It took " + test[1] + " iterations. ");
        } else if (style == 2) {
          System.out.println("For " + square + ", the answer is " + test[0]);
          System.out.println("It took " + test[1] + " iterations.");
        }
      }
      // Asks user if they want to run the program again
      System.out.println("\nCompute another? (y/n)");
      // Instantiates a new Scanner
      // This is ugly but I was having problems using the same variable in as above
      Scanner newIn = new Scanner(System.in);
      String newUserInput = newIn.next();
      promptUser(newUserInput);
    } else if (input.equals("n")) {
      System.out.println("Goodbye!");
    } else {
      // If input is not y or n I just ended the program
      // Could also do a while loop until they enter y or n
      System.out.println("Error, shutting down.");
    }
  }
}