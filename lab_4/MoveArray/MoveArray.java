public class MoveArray
{
  public static void main(String[] args)
  {
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < (values.length - 1); i++) {
      int temp = values[i];
      values[i] = values[i + 1];
      values[i + 1] = temp;
    }
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
    }
  }
}