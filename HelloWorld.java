import java.util.Scanner;

class HelloWorld {
  public static void main(String[] arguments) {
    showGreeting(true);
    String userName = getUsername();
    System.out.println("Hello, " + userName);
  }

  static void showGreeting(Boolean firstVisit) {
    String welcomeText;
    if (firstVisit) 
      welcomeText = "Welcome to Java Program";
    else
      welcomeText = "Welcome back, friendo";

    System.out.println(welcomeText);
  }

  static String getUsername() {
    Scanner scnr = new Scanner(System.in);
    System.out.print("Username: ");
    return scnr.nextLine();
  }
}