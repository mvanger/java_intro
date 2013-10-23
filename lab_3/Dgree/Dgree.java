public class Dgree
{
  public static void main(String[] args)
  {

  }

  public static double reachablePeople(int degree, double averageFriends)
  {
    double total = 1;
    if (degree > 0) {
      total = total + Math.pow(averageFriends, degree);
    }
    return total;
  }
}

// Something something something