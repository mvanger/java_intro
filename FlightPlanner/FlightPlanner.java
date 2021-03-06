/**
MSIA 490 JAVA PROJECT 3
Group:
    Nicole Lim
    Michael Vanger
    Nina (Kathryn?) Wolf
Purpose: This program interfaces with two files to keep track of flight bookings.
General Design: Four options exist for asking the user for input. They can make a new booking, see all bookings,
see the bookings for a specific passenger, or the bookings for a specific flight. There also exist methods to read and write from and to the relevant files.
The prompt user method wraps these other methods.
*/

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

  /**
    Presents the user with a list of opitions that they can conduct with this program
    @params none
    @return none
  */
  public static void promptUser() throws FileNotFoundException
  {
    System.out.println("Welcome to the Flight Planner");
    System.out.println("Please select from one of the following:");
    System.out.println("N - In order to create a new flight reservation");
    System.out.println("S - In order to show all the data for the existing reservations for all the user");
    System.out.println("U - In order to show all the reservations for a particular user");
    System.out.println("B - In order to show the names of the customers who have bookings for a particular flight");
    System.out.println("Q - In order to quit this application");
    Scanner firstIn = new Scanner(System.in);
    String input = firstIn.next();

    // Calls proper method
    if (input.toLowerCase().equals("n")) {
      String[][] flights = readFlightFile();
      String[][] users = readUserFile();
      nMethod(flights, users);
    } else if (input.toLowerCase().equals("s")) {
      sMethod();
    } else if (input.toLowerCase().equals("u")) {
      uMethod();
    } else if (input.toLowerCase().equals("b")) {
      bMethod();
    } else if (input.toLowerCase().equals("q")) {
      // Terminates the program
      System.out.println("Thank you, have a nice day!");
      System.exit(0);
    } else {
      // Restarts the program
      System.out.println("Invalid input. Please enter a valid option:");
      promptUser();
    }
  }

  /**
    Reads in the input file of flight information
    @params none
    @return An array with origin city, destination city, and flight#
  */
  public static String[][] readFlightFile() throws FileNotFoundException
  {
    //Reads flight information text file
    File inputFile = new File("allFlights.txt");
    Scanner secondIn = new Scanner(inputFile);

    //New flight array created
    String[][] flightArray = new String[100][3];

    int i = 0;

    while (secondIn.hasNextLine())
    {
      //Scans each line for origin, destination, and flight #
      String line = secondIn.nextLine();
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(";");
      String origin = lineScanner.next();
      String destination = lineScanner.next();
      String flightID = lineScanner.next();

      //Removes white space
      origin = origin.trim();
      destination = destination.trim();
      flightID = flightID.trim();

      flightArray[i][0] = origin;
      flightArray[i][1] = destination;
      flightArray[i][2] = flightID;
      i++;
      lineScanner.close();
    }
    return flightArray;
  }

  /**
    Reads the file that contains passenger/flight information
    @params none
    @return an array of with passenger name, origin city, destination city, and flight#
  */
  public static String[][] readUserFile() throws FileNotFoundException
  {
    //Reads existing user reservation text file and converts to array
    File inputFile = new File("reservations.txt");
    Scanner thirdIn = new Scanner(inputFile);
    String[][] userArray = new String[100][4];
    int i = 0;

    while (thirdIn.hasNextLine())
    {
      String line = thirdIn.nextLine();
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(";");
      String name = lineScanner.next();
      String origin = lineScanner.next();
      String destination = lineScanner.next();
      String flightID = lineScanner.next();

      name = name.trim();
      origin = origin.trim();
      destination = destination.trim();
      flightID = flightID.trim();

      userArray[i][0] = name;
      userArray[i][1] = origin;
      userArray[i][2] = destination;
      userArray[i][3] = flightID;
      i++;
      lineScanner.close();
    }
    return userArray;
  }

  /**
    Writes new reservations to a text file and saves
    @param outputArray an array with passenger name, origin city, destination city, and flight#
    @return none
    */
  public static void writeUserFile(String[][] outputArray) throws FileNotFoundException
  {
    int i = 0;
    PrintWriter out = new PrintWriter("reservations.txt");
    while(outputArray[i][0] != null)
    {
      for (int j = 0; j < 4; j++)
      {
        out.printf("%s; ", outputArray[i][j]);
      }
    out.println();
    i++;
    }

    out.close();
  }

  /**
    Creates new reservations
    @params flightArray an array with origin city, destination city and flight#, userArray an array with passenger name, origin city, destination city, and flight#
    @return none
  */
  public static void nMethod(String[][] flightArray, String[][] userArray) throws FileNotFoundException
  {
    // Declares 4 arrays for reservation information
    String[] nameArray = new String[100];
    String[] departureArray = new String[100];
    String[] destinationArray = new String[100];
    String[] flightNoArray = new String[100];

    int i = 0;
    int j = 0;
    int k = 0;
    int check = 0;

    // Populates arrays with existing user reservations
    while (userArray[i][0] != null)
    {
      nameArray[i] = userArray[i][0];
      departureArray[i] = userArray[i][1];
      destinationArray[i] = userArray[i][2];
      flightNoArray[i] = userArray[i][3];
      i++;
    }

    //Receives user input for a new reservation
    Scanner fourthIn = new Scanner(System.in);
    System.out.println("Enter the name: ");
    String userName = fourthIn.nextLine();
    System.out.println("Enter the departure city: ");
    String userDeparture = fourthIn.nextLine();
    System.out.println("Enter the destination city: ");
    String userDestination = fourthIn.nextLine();

    nameArray[i] = userName;
    departureArray[i] = userDeparture;
    destinationArray[i] = userDestination;

    //Checks and matches a flight number to the reservation
    while (flightArray[j][0] != null)
    {
      if (departureArray[i].equals(flightArray[j][0]) && destinationArray[i].equals(flightArray[j][1]))
      {
        flightNoArray[i] = flightArray[j][2];
        check = 1;
      }
      j++;
    }

    //Prints if flight information does not match user input
    if (check == 0)
    {
      System.out.println("No matching flights found.");
    }

    //Writes the new reservations to the reservations text file & saves it
    String[][] newOutputArray = new String[100][4];
    while (flightNoArray[k] != null)
    {
    newOutputArray[k][0] = nameArray[k];
    newOutputArray[k][1] = departureArray[k];
    newOutputArray[k][2] = destinationArray[k];
    newOutputArray[k][3] = flightNoArray[k];
    k++;
    }

    // Checks existing combinations
    boolean userExists = false;
    for (int x = 0; x < i; x++) {
      if (newOutputArray[i][0].equals(newOutputArray[x][0]) && newOutputArray[i][3].equals(newOutputArray[x][3])) {
        userExists = true;
        break;
      }
    }
    if (!userExists) {
      writeUserFile(newOutputArray);
    } else {
      System.out.println("Passenger is already booked on that flight.");
    }

    System.out.println();
    promptUser();
  }

  /**
    Shows all the data for the existing reservations for all the users
    @params none
    @return none
  */
  public static void sMethod() throws FileNotFoundException
  {
    // Reads users file
    String[][] outputArray = readUserFile();

    System.out.println("All flights and passengers:");
    //Loops through array and prints out every reservation in the array
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 4; j++) {
        if (outputArray[i][j] != null) {
          System.out.printf("%s; ", outputArray[i][j]);
        }
      }
      if (outputArray[i][0] != null) {
        System.out.printf("\n");
      }
    }
    // Prints if no reservations are found
    if (outputArray[0][0] == null) {
      System.out.println("No reservations were found.");
    }

    System.out.println();
    promptUser();
  }

  /**
    Shows all the reservations for a particular user
    @params none
    @return none
  */
  public static void uMethod() throws FileNotFoundException
  {
    // Gets passenger name from user
    Scanner fifthIn = new Scanner(System.in);
    System.out.println("Enter the name of a passenger you would like to find reservations for: ");
    String passenger = fifthIn.nextLine();

    // Reads users file
    String[][] outputArray = readUserFile();
    // Declares an integer to check if user exists
    int check = 0;
    System.out.println("Flights:");
    // Loops through array to check for user
    for (int i = 0; i < 100; i++) {
      // If passenger is found, prints relevant info
      if (passenger.equals(outputArray[i][0]))
      {
        for (int j = 0; j < 4; j++)
        {
          System.out.printf("%s; ", outputArray[i][j]);
        }
        System.out.println();
        check++;
      }
    }
    // Prints if passenger not found
    if (check == 0)
    {
      System.out.println("Passenger not found.");
    }

    System.out.println();
    promptUser();
  }

  /**
    Show the names of the customers who have bookings for a particular flight
    @params none
    @return none
  */
  public static void bMethod() throws FileNotFoundException
  {
    // Gets flight number from user
    Scanner sixthIn = new Scanner(System.in);
    System.out.println("Enter a flight number:");
    // Instantiates empty string
    String flightNumber = "";
    // Checks for valid flight number input
    while (!flightNumber.matches("\\d{5}") || flightNumber.length() != 5) {
      if (sixthIn.hasNextLine()) {
        flightNumber = sixthIn.nextLine();
      }
      if (!flightNumber.matches("\\d{5}")) {
        System.out.println("Invalid flight number. Flight # is 5 digits.");
      }
    }
    // Reads users file
    String[][] outputArray = readUserFile();
    // Declares an integer to check if flight exists
    int check = 0;
    System.out.println("Passengers:");
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
      System.out.println("Flight not found, or there are no passengers.");
    }

    System.out.println();
    promptUser();
  }
}