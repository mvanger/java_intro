import java.util.ArrayList;

public class TestStuff
{
  public static void main(String[] args)
  {
    final double SOMETHING = 2;
    // Reassigning a final variable gives a compile-time error
    // SOMETHING = 3;
    String test = "Here is a string";
    double[] test2 = {1, 2, 3, 4, 5};
    ArrayList<String> test3 = new ArrayList<String>();
    test3.add("Mike");
    test3.add("Brian");
    // System.out.println(test3);
    String s = "Howdy";
    int k = s.length();

    // for (int i = 1; i < k; i++) {
    //   int j = 0;
    //   while (j <= i) {
    //     j++;
    //     System.out.print(s.substring(i, i+2));
    //   }
    //   System.out.println();
    // }
    System.out.println(pyramidVolume(5, 3));
    // String somestuff = "3.95";
    // System.out.println(Integer.parseInt(Double.parseDouble(somestuff)));
    String somestuff2 = "string\nstuff";
    System.out.println(somestuff2.length());
  }

  public static double pyramidVolume(double height, double baseLength)
  {
    double baseArea = baseLength * baseLength;
    return height * baseArea / 3;
  }
}