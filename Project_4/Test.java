public class Test
{
  public static void main(String[] args)
  {
    Flight plane = new Flight("LA", "Boston", "12345");
    Flight secondPlane = new Flight("Evanston", "Dallas", "65134");
    // System.out.println(plane.getOrigin());
    // System.out.println(plane.getDestination());
    // System.out.println(plane.getFlightNumber());
    // System.out.println(plane);
    // plane.setOrigin("New York");
    // plane.setDestination("Cleveland");
    // plane.setFlightNumber("54321");
    // System.out.println(plane.getOrigin());
    // System.out.println(plane.getDestination());
    // System.out.println(plane.getFlightNumber());
    // System.out.println(plane);
    Passenger me = new Passenger("Mike", plane);
    me.addFlights(secondPlane);
    System.out.println(me);
    System.out.println(me.getFullName());
    System.out.println(me.getFlights());
    System.out.println(me.getFlightDetails());
  }
}