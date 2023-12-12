import java.util.Scanner;

class Calculator {

  public static void main (String [] props) {
    Scanner scnr = new Scanner(System.in);
    String operation = "u";
    int firstNumber;
    int secondNumber;
    int result = 0;
    
    System.out.println("Welcome to Calculator.");
    System.out.println("I will perform an operation on two numbers for you.");
    System.out.println("--------------------------");
    while (operation == "u") {
      operation = getOperation();
      if (operation == "u") {
        System.out.println("Invalid operation, dimwit.");
      }
    }

    System.out.print("What is the first number: ");
    firstNumber = scnr.nextInt();
    System.out.print("What is the second number: ");
    secondNumber = scnr.nextInt();

    switch (operation) {
      case "m":
        result = firstNumber * secondNumber;
        break;
      case "d":
        result = firstNumber / secondNumber;
        break;
      case "a":
        result = firstNumber + secondNumber;
        break;
      case "s":
        result = firstNumber - secondNumber;
        break;
      default:
        System.out.println("I don't know wtf you mean by '" + operation + "'");
        break;
    }
    System.out.println("Your result is " + result);
  }

  static String getOperation() {
    Scanner scnr = new Scanner(System.in);
    System.out.print("What operation do you want to perform (m,d,a,s): ");
    String operation = scnr.nextLine();
    switch (operation) {
      case "m":
      case "d":
      case "a":
      case "s":
        return operation;
      default:
        return "u";
    }
  }

}