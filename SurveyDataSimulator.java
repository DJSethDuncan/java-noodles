import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class SurveyDataSimulator {
  public static void main (String[] props) {

    Scanner scnr = new Scanner(System.in);
    int numberOfSurveys, numberOfUsers;
    ArrayList<Survey> surveys = new ArrayList<Survey>();

    System.out.print("How many surveys do you want to generate: ");
    numberOfSurveys = scnr.nextInt();

    System.out.print("How many users do you want to generate: ");
    numberOfUsers = scnr.nextInt();

    for (int i = 0; i < numberOfSurveys; i++) {
      Scanner surveySetupScnr = new Scanner(System.in);
      int surveyNumber = i + 1;
      Survey thisSurvey = new Survey();

      System.out.print("Survey " + surveyNumber + " name: ");
      String surveyName = surveySetupScnr.nextLine();
      thisSurvey.setId(i);
      thisSurvey.setName(surveyName);

      System.out.print("How many questions will " + thisSurvey.name + " have: ");
      int questionCount = surveySetupScnr.nextInt();
      thisSurvey.generateQuestions(questionCount);

      surveys.add(thisSurvey);
    }

    for (int i = 0; i < numberOfUsers; i++) {
      Scanner userSetupScnr = new Scanner(System.in);
      int userNumber = i + 1;
      User thisUser = new User();

      System.out.print("User " + userNumber + " name: ");
      String userName = userSetupScnr.nextLine();
      thisUser.setId(i + 10);
      thisUser.setName(userName);


      for (int j = 0; j < surveys.size(); j++) {
        Survey thisSurvey = surveys.get(j);
        thisSurvey.generateResponsesForUser(thisUser);
      }
    }

    // generate responses
    // each user responds to every question in every survey with a random number between 1-5

    System.out.println("You generated " + surveys.size() + " surveys.");
    for (int i = 0; i < surveys.size(); i++) {
      Survey thisSurvey = surveys.get(i);
      // list questions and their responses
      System.out.println("'" + thisSurvey.name + "' Questions: ");
      for (int j = 0; j < thisSurvey.questions.size(); j++) {
        Question thisQuestion = thisSurvey.questions.get(j);
        System.out.println(thisQuestion.id + ": '" + thisQuestion.body + "'");
        // get only responses for this question
        ArrayList<Response> thisQuestionResponses = new ArrayList<Response>();
        for (int k = 0; k < thisSurvey.responses.size(); k++) {
          if (thisSurvey.responses.get(k).questionId == thisQuestion.id) {
            thisQuestionResponses.add(thisSurvey.responses.get(k));
          }
        }
        for (int k = 0; k < thisQuestionResponses.size(); k++) {
          Response thisQuestionResponse = thisQuestionResponses.get(k);
          System.out.println("Response from " + thisQuestionResponse.user.name + ": " + thisQuestionResponse.response);
        }
      }
    }

  }
}

class Survey {
  int id;
  String name;
  ArrayList<Response> responses = new ArrayList<Response>();
  ArrayList<Question> questions = new ArrayList<Question>();

  public void setId(int surveyId) {
    id = surveyId;
  }

  public void setName(String surveyName) {
    name = surveyName;
  }

  public void generateQuestions(int questionCount) {
    for (int i = 0; i < questionCount; i++) {
      Question newQuestion = new Question();
      newQuestion.setId(i);
      newQuestion.setBody("Question - " + name + " " + i);
      questions.add(newQuestion);
    }
  }

  public void generateResponsesForUser(User user) {
    for (int i = 0; i < questions.size(); i++) {
      Random rand = new Random();
      Question thisQuestion = questions.get(i);
      Response thisResponse = new Response();
      thisResponse.setId(i * 51);
      thisResponse.setQuestionId(thisQuestion.id);
      thisResponse.setUser(user);
      thisResponse.setResponse(rand.nextInt(4) + 1);
      responses.add(thisResponse);
    }
  }

}

class Question {
  int id;
  String body;

  public void setId(int questionId) {
    id = questionId;
  }

  public void setBody(String questionBody) {
    body = questionBody;
  }
}

class Response {
  int id;
  int questionId;
  User user;
  int response;

  public void setId(int responseId) {
    id = responseId;
  }

  public void setQuestionId(int responseQuestionId) {
    questionId = responseQuestionId;
  }

  public void setUser(User responseUser) {
    user = responseUser;
  }

  public void setResponse(int responseInt) {
    response = responseInt;
  }
}

class User {
  int id;
  String name;

  public void setId(int userId) {
    id = userId;
  }

  public void setName(String userName) {
    name = userName;
  }
}