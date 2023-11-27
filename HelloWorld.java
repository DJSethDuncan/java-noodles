import java.util.Scanner;

class HelloWorld {
  public static void main(String[] arguments) {
    showGreeting(true);
    String userName = getInput("UserName:");
    output("Hello, " + userName + ". What can I do for you today?", true);
    String command;
    do {
      command = getInput("CMD:>");
      processCommand(command, userName);
    }
    while (!command.equals("quit"));
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

  static void processCommand(String command, String userName) {
    switch (command) {
      case "help":
        String[] possibleCommands = getPossibleCommands();
        output("Possible Commands: ", true);
        for (int i = 0; i < possibleCommands.length; i++)
          output("- " + possibleCommands[i], true);
        break;
      case "whoami":
        output("You are " + userName, true);
        break;
      case "quit":
        output("See ya, " + userName + ".", true);
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

  static String[] getPossibleCommands () {
    String[] possibleCommands = new String[]{"help", "whoami", "quit"};
    return possibleCommands;
  }

}