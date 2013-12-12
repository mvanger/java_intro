/**
  This program takes an input file and hashes it with two different methods. Then it writes the hashed output
  to two different files.
  Authors: Nicole Lim, Mike Vanger, Kathryn Wolf
*/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Hashing
{

  public static void main(String[] args) throws FileNotFoundException
  {
    int input = promptUser();
    everything(input);
  }

  /**
    Presents the user with a list of opitions that they can conduct with this program
    @params none
    @return none
  */
  public static int promptUser() throws FileNotFoundException
  {
    System.out.println("Please Select an Array of Size 100 or 200: ");
    Scanner firstIn = new Scanner(System.in);
    String arrayLength = "";

    while (!arrayLength.matches("100") && !arrayLength.matches("200")) {
      if (firstIn.hasNextLine()) {
        arrayLength = firstIn.nextLine();
      }
      if (!arrayLength.matches("100") && !arrayLength.matches("200")) {
        System.out.println("Invalid input. Please enter a valid option:");
      }
    }

    int arrayLengthInt = Integer.parseInt(arrayLength);

    // Calls proper method
    if (arrayLengthInt == 100) {
      return 100;
    } else if (arrayLengthInt == 200) {
      return 200;
    }
    return promptUser();
  }

  /**
    This wraps all the methods together
    @params arrayLength the user input
    @return none
  */
  public static void everything(int arrayLength) throws FileNotFoundException {
    ArrayList<ArrayList<String>> firstHash = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> secondHash = new ArrayList<ArrayList<String>>();
    for (int z = 0; z < arrayLength; z++) {
      firstHash.add(new ArrayList<String>());
      secondHash.add(new ArrayList<String>());
    }
    ArrayList<String> x = readInputFile();
    for (String i : x) {
      int h1 = hashFunction1(i, arrayLength);
      int h2 = hashFunction2(i, arrayLength);
      firstHash.get(h1).add(i);
      secondHash.get(h2).add(i);
    }
    writeOutputFile(firstHash, secondHash);
  }

   /**
    Reads in the input.txt file
    @params none
    @return an ArrayList of every word that was in the input.txt file
  */
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

  /**
    Performs the first hashing function
    @params input thes String to be hashed, size the size of the array
    @return hash1 the hash key
  */
  public static int hashFunction1(String input, int size) throws FileNotFoundException {
    int sum = 0;

    //Loops through each word, converts each character to ASCII decimal value, and sums them
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      int ascii = (int) c;
      sum = sum + ascii;
    }

    //Compresses sum based on array size
    int hash1 = sum % size;
    return hash1;
  }

  /**
    Performs the second hashing function
    @params input thes String to be hashed, size the size of the array
    @return hash2 the hash key
  */
  public static int hashFunction2(String input, int size) throws FileNotFoundException {
    int h = input.hashCode();
    if (h < 0) {
      h = -h;
    }
    int hash2 = h % size;
    return hash2;
  }

  /**
    Writes the output files
    @params firstHash an array of the first hashing method, secondHash an array of the second hashing method
    @return none
  */
  public static void writeOutputFile(ArrayList<ArrayList<String>> firstHash, ArrayList<ArrayList<String>> secondHash) throws FileNotFoundException {

    PrintWriter out = new PrintWriter("output1.txt");
    for (int i = 0; i < firstHash.size(); i++){
      out.print(i);
      if (firstHash.get(i).size() == 0) {
        out.print(" EMPTY LINE...");
      }
      for (String hashValues1 : firstHash.get(i)) {
        out.printf(", %s", hashValues1);
      }
      out.println();
    }

    PrintWriter secondOut = new PrintWriter("output2.txt");
    for (int i = 0; i < secondHash.size(); i++){
      secondOut.print(i);
      if (secondHash.get(i).size() == 0) {
        secondOut.print(" EMPTY LINE...");
      }
      for (String hashValues2 : secondHash.get(i)){
        secondOut.printf(", %s",hashValues2);
      }
      secondOut.println();
    }
    out.close();
    secondOut.close();
  }
}