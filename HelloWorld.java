import java.util.Scanner;

class HelloWorld {
  public static void main(String[] arguments) {
    showGreeting(true);
    String userName = getInput("UserName:");
    output("Hello, " + userName + ". What can I do for you today?", true);
    String command = getInput("CMD:>");
    processCommand(command);
  }

  static void showGreeting(Boolean firstVisit) {
    String welcomeText;
    if (firstVisit) 
      welcomeText = "Welcome to Java Program";
    else
      welcomeText = "Welcome back, friendo";

    output(welcomeText, true);
  }

  static String getInput(String prompt) {
    Scanner scnr = new Scanner(System.in);
    output(prompt + " ", false);
    return scnr.nextLine();
  }

  static void processCommand(String command) {
    switch (command) {
      case "help":
        output("Help yourself.", true);
        break;
      default:
        output("I don't know what you mean.", true);
        break;
    }
  }

  static void output(String text, Boolean newLine) {
    if (newLine)
      System.out.println(text);
    else
      System.out.print(text);
  }

}