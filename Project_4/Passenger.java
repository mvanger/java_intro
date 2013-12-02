/**************PASSENGER CLASS*****************/
import java.util.ArrayList;

public class Passenger {

  String fullName;
  ArrayList<Flight> flights;
  // String origin;
  // String destination;
  // String flightNumber;
  ArrayList<String> flightReservations;

  /**
  Constructs passenger instance variables
  */
  public Passenger () {
    fullName = "";
    flights = new ArrayList<Flight>();
    // origin = "";
    // destination = "";
    // flightNumber = "";
    flightReservations = new ArrayList<String>();
  }

  public Passenger (String name, Flight flight) {
    this.fullName = name;
    // this.origin = origin;
    // this.destination = destination;
    // this.flightNumber = flightNumber;
    this.flights = new ArrayList<Flight>();
    this.flights.add(flight);
    flightReservations = new ArrayList<String>();
    setFlightDetails();
  }


  /**
  Generates full name from first and last name input
  */
  public void setFullName (String name){
    fullName = name;
    // return fullName;
  }

  // public void setOrigin (String departure){
  //   origin = departure;
  // }

  /**
  Sets the destination city.
  */
  // public void setDestination (String arrival){
  //   destination = arrival;
  // }

  /**
  Sets the flight number.
  */
  // public void setFlightNumber (String flightID){
  //   flightNumber = flightID;
  // }

  /**
  Adds a flight
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
    return fullName;
  }

  /**
  Gets the origin city.
  @return the origin city
  */
  // public String getOrigin() {
  //   return origin;
  // }

  /**
  Gets the destination city.
  @return the destination city
  */
  // public String getDestination() {
  //   return destination;
  // }

  // public String getFlightNumber() {
  //   return flightNumber;
  // }

  public ArrayList<Flight> getFlights() {
    return this.flights;
  }

  public void setFlightDetails(){
    for (Flight element : this.flights) {
      this.flightReservations.add(fullName + "; " + element.getOrigin() + "; " + element.getDestination() + "; " + element.getFlightNumber() + ";");
    }
  }

  public ArrayList<String> getFlightDetails(){
    return flightReservations;
  }
}