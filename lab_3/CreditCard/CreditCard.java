public class CreditCard
{
  public static void main(String[] args)
  {

  }

  public static int decode(int input, boolean even)
  {
    int result = 0;
    if (even == false) {
      result = input;
    } else {
      int workingValue = 2 * input
      if (input < 10) {
        result = workingValue;
      } else {
        result = (workingValue % 10) + 1;
      }
    }
    return result;
  }
}