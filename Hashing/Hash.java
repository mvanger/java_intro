import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Hash {

  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<ArrayList<String>> first = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < 30; i++) {
      first.add(new ArrayList<String>());
      // first.get(i).add("a string");
    }
    // first.add(new ArrayList<String>());
    // for (ArrayList<String> y : first) {
      // System.out.println(y.get(0));
    // }
    ArrayList<String> thing = readInputFile();
    for (String z : thing) {
      // System.out.println(z);
      int size = z.length();
      first.get(size).add(z);
    }
    for (ArrayList<String> stuff : first) {
      System.out.println(stuff);
    }
  }

  public static ArrayList<String> readInputFile() throws FileNotFoundException
  {
    //reads provided input file
    File inputFile = new File("input.txt");
    Scanner secondIn = new Scanner(inputFile);

    //Create an Array of each word in the input file
    ArrayList<String> inputArray = new ArrayList<String>();

    while (secondIn.hasNextLine())
    {
      //Scans the docuement and reads a word at a time
      String word = secondIn.next();
      Scanner wordScanner = new Scanner(word);

      //removes the white space
      // wordScanner = wordScanner.trim();

      //add each word to an arraylist
      inputArray.add(word);

      wordScanner.close();
    }
    return inputArray;
  }
}