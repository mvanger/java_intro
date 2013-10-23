public class Luhn
{
 public static void main(String[] args)
 {
 boolean even = false;
 System.out.println(decode(1, even));
 System.out.println(decode(2, even));
 System.out.println(decode(3, even));
 System.out.println(decode(4, even));
 System.out.println(decode(5, even));
 System.out.println(decode(6, even));
 System.out.println(decode(7, even));
 System.out.println(decode(8, even));
 System.out.println(decode(9, even));
 even = ! even;
 System.out.println(decode(1, even));
 System.out.println(decode(2, even));
 System.out.println(decode(3, even));
 System.out.println(decode(4, even));
 System.out.println(decode(5, even));
 System.out.println(decode(6, even));
 System.out.println(decode(7, even));
 System.out.println(decode(8, even));
 System.out.println(decode(9, even));
 }

 public static int decode(int input, boolean even)
  {
    int result = 0;
    if (even == false) {
      result = input;
    } else {
      int workingValue = 2 * input;
      if (workingValue < 10) {
        result = workingValue;
      } else {
        result = (workingValue % 10) + 1;
      }
    }
    return result;
  }
}