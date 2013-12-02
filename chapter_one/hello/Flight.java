/************  FLIGHT CLASS ***********/
  /*
  Contain the flight information (origin city, destination city and flight number) or various flight plans.
*/
public class Flight{
  String origin;
  String destination;
  String flightNumber;

  /**
  Constructs a flight with cleared origin city, destination city and flight number.
  */
  public Flight () {
      origin = "";
      destination = "";
      flightNumber = "";
  }

  public Flight (String origin, String destination, String flightNumber) {
      this.origin = origin;
      this.destination = destination;
      this.flightNumber = flightNumber;
  }

  /**
  Sets the origin city.
  */
  public void setOrigin (String departure){
    origin = departure;
  }
  /**
  Sets the destination city.
  */
  public void setDestination (String arrival){
    destination = arrival;
  }
  /**
  Sets the flight number.
  */
  public void setFlightNumber (String flightID){
    flightNumber = flightID;
  }

  /**
  Gets the origin city.
  @return the origin city
  */
  public String getOrigin () {
    return origin;
  }
    /**
  Gets the destination city.
  @return the destination city
  */
    public String getDestination (){
      return destination;
    }
  /**
  Gets the flight number.
  @return the flight number
  */
  public String getFlightNumber (){
    return flightNumber;
  }

}


