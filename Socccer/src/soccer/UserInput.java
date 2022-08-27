package soccer;

import java.util.Scanner;

public class UserInput {

  public static int getInteger() {
    Scanner input = new Scanner(System.in);
    try {
      int x;
      x = input.nextInt();
      return x;
    } catch (Exception e) {
      System.out.println("Error");
      return -1;
    }
  }

  public static double getDouble() {
    Scanner input = new Scanner(System.in);
    try {
      double x;
      x = input.nextDouble();
      return x;
    } catch (Exception e) {
      System.out.println("Error");
      return -1;
    }
  }

  public static float getFloat() {
    Scanner input = new Scanner(System.in);
    try {
      float x;
      x = input.nextFloat();
      return x;
    } catch (Exception e) {
      System.out.println("Error");
      return -1;
    }
  }

  public static String getString() {
    Scanner input = new Scanner(System.in);
    String x;
    x = input.nextLine();
    return x;
  }
}
