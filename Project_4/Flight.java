/************  FLIGHT CLASS ***********/
  /*
  Contain the flight information (origin city, destination city and flight number) or various flight plans.
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

  public Flight(String originCity, String destinationCity, String flightID) {
    this.origin = originCity;
    this.destination = destinationCity;
    this.flightNumber = flightID;
  }

  /**
  Sets the origin city.
  */
  public void setOrigin(String departureCity){
    this.origin = departureCity;
  }

  /**
  Sets the destination city.
  */
  public void setDestination(String arrivalCity){
    this.destination = arrivalCity;
  }

  /**
  Sets the flight number.
  */
  public void setFlightNumber(String flightID){
    this.flightNumber = flightID;
  }

  /**
  Gets the origin city.
  @return the origin city
  */
  public String getOrigin() {
    return origin;
  }

  /**
  Gets the destination city.
  @return the destination city
  */
  public String getDestination() {
    return destination;
  }

  /**
  Gets the flight number.
  @return the flight number
  */
  public String getFlightNumber() {
    return flightNumber;
  }
}