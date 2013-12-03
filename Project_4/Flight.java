/**
A Flight, with origin, destination, and flight number
*/
public class Flight{
  private String origin;
  private String destination;
  private String flightNumber;

  /**
  Constructs a flight with cleared origin city, destination city and flight number.
  */
  public Flight() {
    this.origin = "";
    this.destination = "";
    this.flightNumber = "";
  }

  /**
  Constructs a flight with inputs of origin, destination, and flightID
  @params originCity the origin, destinationCity the destination, flightID the flight ID number
  */
  public Flight(String originCity, String destinationCity, String flightID) {
    this.origin = originCity;
    this.destination = destinationCity;
    this.flightNumber = flightID;
  }

  /**
  Sets the origin city.
  @param departureCity the origin
  */
  public void setOrigin(String departureCity){
    this.origin = departureCity;
  }

  /**
  Sets the destination city.
  @param arrivalCity the destination
  */
  public void setDestination(String arrivalCity){
    this.destination = arrivalCity;
  }

  /**
  Sets the flight number.
  @param flightID the flight ID number
  */
  public void setFlightNumber(String flightID){
    this.flightNumber = flightID;
  }

  /**
  Gets the origin city.
  @return the origin city
  */
  public String getOrigin() {
    return this.origin;
  }

  /**
  Gets the destination city.
  @return the destination city
  */
  public String getDestination() {
    return this.destination;
  }

  /**
  Gets the flight number.
  @return the flight number
  */
  public String getFlightNumber() {
    return this.flightNumber;
  }
}