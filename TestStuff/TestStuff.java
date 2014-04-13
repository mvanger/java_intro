import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class TestStuff
{
  public static void main(String[] args)
  {
    // final double SOMETHING = 2;
    // // Reassigning a final variable gives a compile-time error
    // // SOMETHING = 3;
    // String test = "Here is a string";
    // double[] test2 = {1, 2, 3, 4, 5};
    // ArrayList<String> test3 = new ArrayList<String>();
    // test3.add("Mike");
    // test3.add("Brian");
    // // System.out.println(test3);
    // String s = "Howdy";
    // int k = s.length();

    // // for (int i = 1; i < k; i++) {
    // //   int j = 0;
    // //   while (j <= i) {
    // //     j++;
    // //     System.out.print(s.substring(i, i+2));
    // //   }
    // //   System.out.println();
    // // }
    // System.out.println(pyramidVolume(5, 3));
    // // String somestuff = "3.95";
    // // System.out.println(Integer.parseInt(Double.parseDouble(somestuff)));
    // String somestuff2 = "string\nstuff";
    // System.out.println(somestuff2.length());
    // String test = "0029029070999991901010106004+64333+023450FM-12+000599999V0202701N015919999999N0000001N9-00781+99999102001ADDGF108991999999999999999999";
    // String year = test.substring(15,19);
    // String temp = test.substring(87,92);
    // String[] ACCURACY = new String[] {"0","1","4","5","9"};
    // ArrayList<String> values = new ArrayList<String>();
    // values.add("-0078");
    // values.add("-0000");
    // values.add("14524");
    // values.add("00421");
    // values.add("00000");
    // values.add("99999");
    // String max = Collections.max(values);
    // System.out.println("12345".compareTo("2345"));
    // System.out.println(Arrays.asList(ACCURACY).contains(test.substring(92,93)));
    // System.out.println(max);
    // System.out.println(temp);
    String line = "100001.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,1.714519404344681,1.714519404344681,0.0,0.23809815408534968,0.0,0.23809815408534968,13.522764205932617,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,1.0,-11.724874105386709,0.0,0.0,1.0,0.0,0.0,1.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.8333333333333334,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,2.0,0.0,0.0,0.0,0.0,0.0325,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,0.0,0.0,1.0,1.0,0.0,0.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,0.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,0.0,1.0,0.0,0.0,1.0,1.0,1.0,0.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,0.0,1.0,1.0,0.0,0.0,0.0,-0.7639173260267851,0.9504183401542128,0.0,-0.15357378122653567,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.14200975767193244,0.26852313000382516,-0.2090731331476715,0.4771845879530998,0.0,0.4771845879530998,1.4295431150606932,0.31862648894691914,0.37696851792022934,0.5043166196653175,0.6324555360390127,0.7947194027343922,0.8742011487132785,0.9862693884550009,1.042371549474532,1.222396379034316,1.362080463127538,1.7162326533832233,2.242270636611143,2.8357832760169357,-0.2197934878572082,-0.784541653468629,-0.11061668495522065,-0.8477314592466477,0.0,0.0,-0.1686298282961996,0.8257896766936441,0.0,-0.27457169442210166,0.0,0.3849001804621283,0.0,0.0,0.0,0.0,0.0,0.0,-1.0151421479620046,-0.8917099634547999,-0.7841026370535708,0.7942460237892165,0.0,0.0,0.0,0.0,0.0,0.0,0.0,-0.18257418638944184,0.0,-0.26908864780877395,-0.2622967642586007,-0.14170107956017297,0.0,0.0,-0.38315438734316665,-0.360843913549849,0.0,0.0,0.0,0.0,-0.06804138085903029,-0.10310923820878684,-0.22230470260035518,-0.3898198926700401,-0.2812930444661995,0.0,0.0,0.0,0.0,-0.016538052447886233,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,-0.15357378122653567,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,-0.2698314082560682,-0.5066149125807233,0.0,0.0,false";
    String[] splits = line.split(",");
    // System.out.println(splits[29].substring(0,1));
    // System.out.println(splits[30].substring(0,1));
    // System.out.println(splits[31].substring(0,1));
    // System.out.println(splits[32].substring(0,1));
    String combo1 = splits[29].substring(0,1);
    String combo2 = splits[30].substring(0,1);
    String combo3 = splits[31].substring(0,1);
    String combo4 = splits[32].substring(0,1);
    Double value = Double.parseDouble(splits[3]);
    System.out.println("the key is: " + combo1 + combo2 + combo3 + combo4);
    System.out.println("the value is: " + value);
    System.out.println("the last column is: " + splits[splits.length-1]);
    System.out.println(splits[splits.length-1].equals("false"));
    double sum = 25.5;
    int counter = 5;
    double avg = sum/counter;
    System.out.println(avg);

  }

  public static double pyramidVolume(double height, double baseLength)
  {
    double baseArea = baseLength * baseLength;
    return height * baseArea / 3;
  }
}