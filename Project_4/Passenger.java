import java.util.ArrayList;

/**
A Passenger, with a name and an array of flights
*/
public class Passenger {
  private String fullName;
  private ArrayList<Flight> flights;
  private ArrayList<String> flightReservations;

  /**
  Constructs passenger instance
  */
  public Passenger() {
    this.fullName = "";
    this.flights = new ArrayList<Flight>();
    this.flightReservations = new ArrayList<String>();
  }

  /**
  Constructs passenger instance
  @params name the passenger name, flight the first flight he/she is booked on
  */
  public Passenger(String name, Flight flight) {
    this.fullName = name;
    this.flights = new ArrayList<Flight>();
    this.flights.add(flight);
    this.flightReservations = new ArrayList<String>();
    setFlightDetails();
  }

  /**
  Generates full name from first and last name input
  @param name the passenger's name
  */
  public void setFullName(String name){
    this.fullName = name;
  }

  /**
  Adds a flight
  @param flight the flight to be added
  */
  public void addFlight(Flight flight) {
    this.flights.add(flight);
    this.flightReservations.add(fullName + "; " + flight.getOrigin() + "; " + flight.getDestination() + "; " + flight.getFlightNumber() + ";");
  }

  /**
  Gets the full name of the passenger
  @return the passenger name
  */
  public String getFullName() {
    return this.fullName;
  }

  /**
  Gets the flights the passenger is booked on
  @return an array of all flights the passenger is booked on
  */
  public ArrayList<Flight> getFlights() {
    return this.flights;
  }

  /**
  Sets the flight details as a semicolon delimited line
  */
  public void setFlightDetails(){
    for (Flight element : this.flights) {
      this.flightReservations.add(fullName + "; " + element.getOrigin() + "; " + element.getDestination() + "; " + element.getFlightNumber() + ";");
    }
  }

  /**
  Gets the flight details
  @return an array of flight details
  */
  public ArrayList<String> getFlightDetails(){
    return this.flightReservations;
  }
}