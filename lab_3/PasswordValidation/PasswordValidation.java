import java.util.Scanner;

public class PasswordValidation
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter a password:");
    String password = in.next();
    if (isPasswordLegit(password) == true) {
      System.out.println("Please enter the password confirmation:");
      String passwordConfirmation = in.next();
      if (doPasswordsMatch(password, passwordConfirmation)) {
        System.out.println("OK");
      } else {
        System.out.println("Passwords do not match");
      }
    }




  }

  public static boolean isPasswordLegit(String password)
  {
    boolean length = false;
    boolean uppercase = false;
    boolean lowercase = false;
    boolean digit = false;
    boolean result = false;

    if (password.length() >= 8) {
      length = true;
    }
    if (password.toUpperCase().equals(password)) {
      uppercase = true;
    }
    if (password.toLowerCase().equals(password)) {
      lowercase = true;
    }
    if (password.contains("0")) {
      digit = true;
    }
    if (length == true && uppercase == true && lowercase == true && digit == true) {
      result = true;
    }
    return result;
    // bool match = false;
  }

  public static boolean doPasswordsMatch(String password, String confirmation)
  {
    boolean result = false;
    if (password.equals(confirmation)) {
      result = true;
    }
    return result;
  }
}