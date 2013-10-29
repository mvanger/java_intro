public class RandomArray
{
  public static void main(String[] args)
  {
    // System.out.println(100 * Math.random());
    int[] values = new int[10];
    // for (int i = 0; i < 10; i++) {
    //   values[i] = (int)(100 * Math.random() + 1);
    //   System.out.println(values[i]);
    // }
    for (int i = 0; i < 10; i++) {
      values[i] = (int)(100 * Math.random() + 1);
      for (int j = 0; j < 10; j++) {
        if (values[j] == values[i]) {
          values[i] = (int)(100 * Math.random() + 1);
        }
      }
      System.out.println(values[i]);
    }
  }
}

// Young's solution is better