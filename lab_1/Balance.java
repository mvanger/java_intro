public class Balance
{
  public static void main(String[] args)
  {
    int month = 0;
    double balance = 10000;
    double interest = 0.005;
    while (balance > 0)
    {
      month++;
      balance = (1 + interest) * balance;
      balance = balance - 500;
    }
    System.out.println(month + " months");
  }
}