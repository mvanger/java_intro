import java.util.*;

public class HelloPrinter // Declares the class HelloPrinter
{
  // main is a method
  // function or procedure is strictly a method in Java
  public static void main(String[] args)
  {
    // System.out.println is a method within the main method
    // Strings have to be enclosed in double quotations
    // Use a \ to escape a character
    // System.out.print() will not add a new line after
    // System.out.println() will
    // Java is strongly typed
    System.out.println("Hello, World! It's my second Java program.");
    System.out.println("Here is an extra \" quotation mark");
    System.out.println("Here is a \n new line");
    System.out.println("Here is a \nnew line without the extra space");
    System.out.println(.1 + .2);
    String test = "Here is a string";
    System.out.println(test.charAt(0));
    int[] test2 = new int[10];
    System.out.println(test2.length);
    System.out.println(test.length());
    double[] values = {1, 2, 3};
    double total = 0;
    for (double something : values) {
      total = total + something;
    }
    System.out.println(total);
    System.out.println(Arrays.toString(values));
    String somestring = "here is a string";
    String someotherstring = somestring;
    System.out.println(someotherstring);
    someotherstring = someotherstring + "concatenated";
    System.out.println(somestring);
    System.out.println(someotherstring);
    // So you can actually have arrays that contain objects of different classes
    Object[] anArray = {"String", 1, 1.5};
    System.out.println(Arrays.toString(anArray));
    Flight airplane = new Flight("Boston", "Chicago", "12345");
    System.out.println(airplane.getOrigin());
    System.out.println(airplane.getDestination());
    System.out.println(airplane.getFlightNumber());
  }
}

// Declaring a variable requires the type and the name
// Defining a variable sets the content
// for example "int cansPerPack;" is a declaration
// and "int cansPerPack = 6;" is a definition