import java.util.Arrays;
import java.util.ArrayList;

public class ReviewQuestions
{
  public static void main(String[] args)
  {
    int[] test = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
    int[] output = reverseValues(test);
    System.out.println(Arrays.toString(output));
    for (int potato : test) {
      System.out.println(potato);
    }
    printValues(test);
    System.out.println(computeProduct(test));
    System.out.println(countNegatives(test));
    diceToss();
    ArrayList<String> names = new ArrayList<String>();
    names.add("Cindy");
    names.add("Apu");
    names.add("Apu");
    // runtime error
    // names.add(5, "Kathryn");
    names.remove("Apu");
    System.out.println(names);
    printChar("Some test", 'e');
    String somestuff = "Some stuff";
    System.out.println(somestuff.substring(1,2));
  }

  public static int[] reverseValues(int[] inputArray)
  {
    int[] result = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      result[i] = inputArray[inputArray.length - 1 - i];
    }
    return result;
  }

  public static void printValues(int[] inputArray)
  {
    for (int element : inputArray) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static int computeProduct(int[] inputArray)
  {
    int total = 1;
    for (int element : inputArray) {
      total *= element;
    }
    return total;
  }

  public static int countNegatives(int[] inputArray)
  {
    int total = 0;
    for (int element : inputArray) {
      if (element < 0) {
        total += 1;
      }
    }
    return total;
  }

  public static void diceToss()
  {
    int[] toss = new int[20];
    for (int i = 0; i < 20; i++) {
      toss[i] = ((int)(Math.random() * 6) + 1);
    }
    System.out.println(Arrays.toString(toss));
  }

  public static void printChar(String inputString, char inputChar)
  {
    int length = inputString.length();
    for (int i = 0; i < length; i++) {
      if (inputString.charAt(i) == (inputChar)) {
        System.out.println(inputString.charAt(i + 1));
      }
    }
  }
}