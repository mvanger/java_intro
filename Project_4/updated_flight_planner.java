
/**********FLIGHT PLANNER ***********/
public class FlightPlanner {

  public static void main(String[] args) throws FileNotFoundException
    {
      promptUser();
    }

    /**
     * Presents the user with a list of options that they can conduct with this program
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
      Scanner test = new Scanner(System.in);
      String input = test.next();

      // Calls proper method
      if (input.toLowerCase().equals("n")) {
        ArrayList<Flight> flights = readFlightFile();
        ArrayList<Passenger> users = readUserFile();
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
     * Reads in the input file of flight information
     * @return An array with origin city, destination city and flight#
     */
    public static ArrayList<Flight> readFlightFile() throws FileNotFoundException
    {
      //Reads flight information text file
      File inputFile = new File("allFlights.txt");
      Scanner secondIn = new Scanner(inputFile);

      //New array created
      ArrayList<Flight> flightArray = new ArrayList<Flight>();

      flightArray.add(new Flight ());

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

        Flight newFlight = new Flight();

        newFlight.setOrigin(origin);
        newFlight.setDestination(destination);
        newFlight.setFlightNumber(flightID);
        flightArray.add(newFlight);
        lineScanner.close();
      }

      return flightArray;
    }

    /**
     * inputs the file that contains flight information
     * @return an array of with passenger name, origin city, destination city and flight#
     */
    public static ArrayList<Passenger> readUserFile() throws FileNotFoundException
    {
          //Reads existing user reservation text file and converts to array

      File inputFile = new File("reservations.txt");
      Scanner thirdIn = new Scanner(inputFile);
      ArrayList<Passenger> userArray = new ArrayList<Passenger>();

      userArray.add(new Passenger ());

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

        Passenger newPassenger = new Passenger();
        newPassenger.setFullName(name);
        newPassenger.setOrigin(origin);
        newPassenger.setDestination(destination);
        newPassenger.setFlightNumber(flightID);
        userArray.add(newPassenger);
        lineScanner.close();
      }

      return userArray;
    }

  /**
   * Writes new reservations to a text file and saves
   * @param outputArray an array with passenger name, origin city, destination city and flight#
   **/
    public static void writeUserFile(ArrayList<Passenger> outputArray) throws FileNotFoundException
    {
      PrintWriter out = new PrintWriter("reservations.txt");
      for(int i = 1; i < outputArray.size(); i++) {
      out.println(outputArray.get(i).getFullName() + "; "+ outputArray.get(i).getOrigin() + "; "+ outputArray.get(i).getDestination() + "; " + outputArray.get(i).getFlightNumber() + ";");
      }
      out.close();
    }

    /**
     * Creates new reservations
     * @param flightArray an array with origin city, destination city and flight#, userArray an array with passenger name, origin city, destination city and flight#
     */
    public static void nMethod(ArrayList<Flight> flightArray, ArrayList<Passenger> userArray) throws FileNotFoundException
    {

      int check = 0;

      //Receives user input for a new reservation
      Scanner fourthIn = new Scanner(System.in);
      System.out.println("Enter the name: ");
      String userName = fourthIn.nextLine();
      System.out.println("Enter the departure city: ");
      String userDeparture = fourthIn.nextLine();
      System.out.println("Enter the destination city: ");
      String userDestination = fourthIn.nextLine();

      Passenger newPassenger = new Passenger();
      newPassenger.setFullName(userName);
      newPassenger.setOrigin(userDeparture);
      newPassenger.setDestination(userDestination);
      userArray.add(newPassenger);


      //Checks and matches a flight number to the reservation
      for (int j = 0; j<flightArray.size(); j++)
      {
        if (userArray.get(userArray.size()-1).origin.equals(flightArray.get(j).origin) && userArray.get(userArray.size()-1).destination.equals(flightArray.get(j).destination))
        {
          userArray.get(userArray.size()-1).flightNumber = flightArray.get(j).flightNumber;
          check = 1;
        }

      }

      //Prints if flight information does not match user input
      if (check == 0)
      {
        System.out.println("No matching flights found.");
        // System.exit(0);
      }

      //Writes the new reservations to the reservations text file & saves it

      writeUserFile(userArray);
      promptUser();

    }



}
