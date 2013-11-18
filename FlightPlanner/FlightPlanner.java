import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FlightPlanner
{
  public static void main(String[] args) throws FileNotFoundException
  {
    promptUser();
  }

  public static void promptUser() throws FileNotFoundException
  {
    // Prints welcome message and options
    System.out.println("Welcome to the Flight Planner");
    System.out.println("Please Select From One of the Following:");
    System.out.println("N - In order to create a new flight reservation");
    System.out.println("S - In order to show all the data for the existing reservations for all the user");
    System.out.println("U - In order to show all the reservations for a particular user");
    System.out.println("B - In order to show the names of the customers who have bookings for a particular flight");
    System.out.println("Q - In order to quit this application");
    Scanner in = new Scanner(System.in);
    String input = in.next();
    // Calls proper method
    if (input.toLowerCase().equals("n")) {
      nMethod();
    } else if (input.toLowerCase().equals("s")) {
      sMethod();
    } else if (input.toLowerCase().equals("u")) {
      uMethod();
    } else if (input.toLowerCase().equals("b")) {
      bMethod();
    } else if (input.toLowerCase().equals("q")) {
      // prints the statement below
      System.out.println("Thank you, have a nice day!");
    } else {
      // Restarts this method
      System.out.println("Invalid input");
      promptUser();
    }
  }

  public static String[][] readFlightFile() throws FileNotFoundException
  {
    // input the file here
    // returns an array of 3 arrays (origin, destination, flight#)
    File inputFile = new File("allFlights.txt");
    Scanner in = new Scanner(inputFile);
    String[][] outputArray = new String[100][3];
    int i = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(";");
      String origin = lineScanner.next();
      String destination = lineScanner.next();
      String flightID = lineScanner.next();
      outputArray[i][0] = origin;
      outputArray[i][1] = destination;
      outputArray[i][2] = flightID;
      i++;
      lineScanner.close();
    }
    in.close(); //close scanner

    // print to check:
    /*
    for(int j = 0; j<10; j++)
      {
      for(int k = 0; k<3; k++)
      {
        System.out.print(outputArray[j][k]);
      }
      System.out.println();
    }
    */
    return outputArray;
  }

  public static String[][] readUserFile() throws FileNotFoundException
  {
    // input the user file & return 4 arrays (passenger, origin, destination, flight#)
    File inputFile = new File("users.txt");
    Scanner in = new Scanner(inputFile);
    String[][] outputArray = new String[100][4];
    int i = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(";");
      String name = lineScanner.next();
      String origin = lineScanner.next();
      String destination = lineScanner.next();
      String flightID = lineScanner.next();
      outputArray[i][0] = name;
      outputArray[i][1] = origin;
      outputArray[i][2] = destination;
      outputArray[i][3] = flightID;
      i++;
      lineScanner.close();
    }
    in.close();
    return outputArray;
  }

  public static void writeUserFile()
  {
    // write the file
  }

  public static void nMethod()
  {
        //declare 4 arrays to be populated with flight information
    String[] nameArray = new String[100];
    String[] departureArray = new String[100];
    String[] destinationArray = new String[100];
    String[] flightNoArray = new String[100];


    int i = 0;
    int j = 0;

    //populate arrays with existing user reservations
    while (userArray[i][0] != null)
    {
      nameArray[i] = userArray[i][0];
      departureArray[i] = userArray[i][1];
      destinationArray[i] = userArray[i][2];
      flightNoArray[i] = userArray[i][3];
      i++;
    }

    //user input for new reservation
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name: ");
    String userName = in.nextLine();
    System.out.println("Enter the departure city: ");
    String userDeparture = in.nextLine();
    System.out.println("Enter the destination city: ");
    String userDestination = in.nextLine();

    nameArray[i] = userName;
    departureArray[i] = userDeparture;
    destinationArray[i] = userDestination;

    //check and match from flight array to user array

    //while (flightArray[j][0] != null)
    //{
    for(j = 0; j < 10; j++){
      if (departureArray[i].equals(flightArray[j][0]) && destinationArray[i].equals(flightArray[j][1]))
      {
        //if (destinationArray[i].equals(flightArray[j][1]))
        //{
        flightNoArray[i] = flightArray[j][2];
        //}
      }
    }
    //}

    System.out.print(Arrays.toString(flightNoArray));
    //write the new reservations to the text file, save
    //writeUserFile method here**

  }

  public static void sMethod() throws FileNotFoundException
  {
    // Prints out exisitng reservations
    // Reads users file
    String[][] outputArray = readUserFile();
    //Loops through array and prints out every reservation in the array
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 4; j++) {
          if (outputArray[i][j] != null) {
            System.out.print(outputArray[i][j]);
          }
       }
       if (outputArray[i][0] != null) {
         System.out.println();
       }
    }
    // Prints if no reservations are found
    if (outputArray[0][0] == null) {
       System.out.println("No Reservations were found.");
    }
    promptUser();
  }

  public static void uMethod() throws FileNotFoundException
  {
    // Gets passenger name from user
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name of a passenger you would like to find reservations for: ");
    String passenger = in.nextLine();
    // Reads users file
    String[][] outputArray = readUserFile();
    // Declares an integer to check if user exists
    int check = 0;
    // Loops through array to check for user
    for (int i = 0; i < 100; i++) {
      // If passenger is found, prints relevant info
      if (passenger.equals(outputArray[i][0])) {
        for (int j = 0; j < 4; j++) {
          System.out.print(outputArray[i][j]);
        }
        System.out.println();
        check++;
      }
    }
    // Prints if passenger not found
    if (check == 0) {
      System.out.println("Passenger not found.");
    }
    promptUser();
  }

  public static void bMethod() throws FileNotFoundException
  {
    // Gets flight number from user
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a flight number:");
    String flightNumber = " " + in.nextLine();
    // Reads users file
    String[][] outputArray = readUserFile();
    // Declares an integer to check if flight exists
    int check = 0;
    // Loops through array to check for flight
    for (int i = 0; i < 100; i++) {
      // If flight is found, prints passenger info
      if (flightNumber.equals(outputArray[i][3])) {
        // for (int j = 0; j < 4; j++) {
        // Prints passenger name only
        //// Should it print O-D and Flight # too?
        System.out.print(outputArray[i][0]);
        // }
        System.out.println();
        check++;
      }
    }
    // Prints if flight/passenger not found
    if (check == 0) {
      System.out.println("Flight not found/no passengers.");
    }
    promptUser();
  }
}